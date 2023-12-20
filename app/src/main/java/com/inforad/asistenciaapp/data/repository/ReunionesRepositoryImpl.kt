package com.inforad.asistenciaapp.data.repository

import android.util.Log
import com.inforad.asistenciaapp.data.dataSource.local.ReunionLocalDataSource
import com.inforad.asistenciaapp.data.dataSource.local.entity.ReunionEntity
import com.inforad.asistenciaapp.data.dataSource.remote.ReunoinesRemoteDataSource
import com.inforad.asistenciaapp.data.mapper.toReunion
import com.inforad.asistenciaapp.data.mapper.toReunionEntity
import com.inforad.asistenciaapp.domain.model.EstadoReunion
import com.inforad.asistenciaapp.domain.model.Reunion
import com.inforad.asistenciaapp.domain.repository.ReunionRepository
import com.inforad.asistenciaapp.domain.util.Resource
import com.inforad.asistenciaapp.domain.util.ResponseToRequest
import com.inforad.asistenciaapp.domain.util.isListEqual
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.single
import kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck.Equals

class ReunionesRepositoryImpl(
    private val remoteDataSource: ReunoinesRemoteDataSource,
    private val localDataSoruce: ReunionLocalDataSource
    ): ReunionRepository {
    override suspend fun create(reunion: Reunion): Resource<Reunion> = ResponseToRequest.send(
        remoteDataSource.create(reunion)
    )

    override fun getReuniones(): Flow<Resource<List<Reunion>>> = flow {
        localDataSoruce.getReuniones().collect() {
            it.run {
                val reunionLocalMap = this.map { reunionEntity -> reunionEntity.toReunion() }
                try {
                    ResponseToRequest.send(remoteDataSource.getReuniones()).run {
                        when(this) {
                            is Resource.Success -> {
                                val reunionesRemote = this.data
                                if (!isListEqual(reunionesRemote, reunionLocalMap)) {
                                    localDataSoruce.createAll(reunionesRemote.map { reunion -> reunion.toReunionEntity() })
                                }
                                emit(Resource.Success(reunionesRemote))
                            }
                            is Resource.Failure -> {
                                emit(Resource.Success(reunionLocalMap))
                            }
                            else -> {
                                emit(Resource.Success(reunionLocalMap))
                            }
                        }
                    }
                } catch (e: Exception) {
                    emit(Resource.Success(reunionLocalMap))
                }
            }
        }
    }.flowOn(Dispatchers.IO)

    override fun getAllReuniones(): Flow<Resource<List<Reunion>>> = flow {
        localDataSoruce.getAllReuniones().collect() {
            it.run {
                val reunionLocalMap = this.map { reunionEntity -> reunionEntity.toReunion() }
                try {
                    ResponseToRequest.send(remoteDataSource.getAllReuniones()).run {
                        when(this) {
                            is Resource.Success -> {
                                val reunionesRemote = this.data
                                if (!isListEqual(reunionesRemote, reunionLocalMap)) {
                                    localDataSoruce.createAll(reunionesRemote.map { reunion -> reunion.toReunionEntity() })
                                }
                                emit(Resource.Success(reunionesRemote))
                            }
                            is Resource.Failure -> {
                                emit(Resource.Success(reunionLocalMap))
                            }
                            else -> {
                                emit(Resource.Success(reunionLocalMap))
                            }
                        }
                    }
                } catch (e: Exception) {
                    emit(Resource.Success(reunionLocalMap))
                }
            }
        }
    }.flowOn(Dispatchers.IO)


    override suspend fun getLastReunion(): Resource<Reunion> {
        return try {
            val remoteReunionResponse = ResponseToRequest.send(remoteDataSource.getLastReunion())
            if (remoteReunionResponse is Resource.Success) {
                val remoteReunion = remoteReunionResponse.data
                localDataSoruce.create(remoteReunion.toReunionEntity())
                Resource.Success(remoteReunion)
            } else {
                val localReunionEntity = localDataSoruce.getLastReunion()
                Resource.Success(localReunionEntity.toReunion())
            }
        } catch (e: Exception) {
            val localReunionEntity = localDataSoruce.getLastReunion()
            Resource.Success(localReunionEntity.toReunion())
        }
    }

    override suspend fun update(id: String, reunion: Reunion): Resource<Reunion> {
        TODO("Not yet implemented")
    }

    override suspend fun cerrarReunion(id: String, estado: EstadoReunion): Resource<Reunion> = ResponseToRequest.send(
        remoteDataSource.cerrarReunion(id, estado)
    )

    override suspend fun delete(id: String): Resource<Unit> {
        TODO("Not yet implemented")
    }
}