package com.inforad.asistenciaapp.data.repository

import android.util.Log
import com.inforad.asistenciaapp.data.dataSource.local.UserLocalDataSource
import com.inforad.asistenciaapp.data.dataSource.local.entity.UserEntity
import com.inforad.asistenciaapp.data.dataSource.remote.UsersRemoteDataSource
import com.inforad.asistenciaapp.data.mapper.toUser
import com.inforad.asistenciaapp.data.mapper.toUserEntity
import com.inforad.asistenciaapp.domain.model.User
import com.inforad.asistenciaapp.domain.repository.UserRepository
import com.inforad.asistenciaapp.domain.util.Resource
import com.inforad.asistenciaapp.domain.util.ResponseToRequest
import com.inforad.asistenciaapp.domain.util.isListEqual
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.File

class UsersRepositoryImpl(
    private val remoteDataSource: UsersRemoteDataSource,
    private val localDataSource: UserLocalDataSource
): UserRepository {
    override suspend fun update(id: String, user: User): Resource<User> {
        ResponseToRequest.send(remoteDataSource.update(id, user)).run {
            return when(this) {
                is Resource.Success -> {
                    localDataSource.update(
                        id = this.data.id ?: "",
                        name = this.data.name,
                        lastname = this.data.lastname,
                        dni = this.data.dni ?: "",
                        email = this.data.email ?: "",
                        phone = this.data.phone,
                        numero_padron = this.data.numeroPadron.toString(),
                        manzana = this.data.manzana,
                        metros = this.data.metros,
                        lotes_detalle = this.data.lotesDetalle,
                        image = this.data.imagen ?: "",
                    )
                    Resource.Success(this.data)
                }
                else -> {
                    Resource.Failure("Error Desconocio")
                }
            }
        }
    }

    override fun getUsers(): Flow<Resource<List<User>>> = flow {

        localDataSource.getUsers().collect() {
            it.run {
                val usersLocalMap = this.map { userEntity -> userEntity.toUser() }
                try {
                    ResponseToRequest.send(remoteDataSource.getUsers()).run {
                        when(this) {
                            is Resource.Success -> {
                                val usersRemote = this.data

                                if (!isListEqual(usersRemote, usersLocalMap)) {
                                    localDataSource.createAll(usersRemote.map { user -> user.toUserEntity() })
                                }

                                emit(Resource.Success(usersRemote))
                            }
                            is Resource.Failure -> {
                                emit(Resource.Success(usersLocalMap))
                            }
                            else -> {
                                emit(Resource.Success(usersLocalMap))
                            }
                        }
                    }
                } catch (e: Exception) {
                    emit(Resource.Success(usersLocalMap))
                }
            }
        }

    }.flowOn(Dispatchers.IO)

    override fun findByName(dato: String): Flow<Resource<List<User>>> = callbackFlow {
        trySend(ResponseToRequest.send(remoteDataSource.findByName(dato)))
        awaitClose {
            cancel()
        }
    }

    override suspend fun updateWithImage(id: String, user: User, file: File): Resource<User> {
        ResponseToRequest.send(remoteDataSource.updateWithImage(id, user, file)).run {
            return when(this) {
                is Resource.Success -> {
                    localDataSource.update(
                        id = this.data.id ?: "",
                        name = this.data.name,
                        lastname = this.data.lastname,
                        dni = this.data.dni ?: "",
                        email = this.data.email ?: "",
                        phone = this.data.phone,
                        numero_padron = this.data.numeroPadron.toString(),
                        manzana = this.data.manzana,
                        metros = this.data.metros,
                        lotes_detalle = this.data.lotesDetalle,
                        image = this.data.imagen ?: "",
                    )
                    Resource.Success(this.data)
                }
                else -> {
                    Resource.Failure("Error Desconocido")
                }
            }
        }
    }

    override suspend fun createWithImage(user: User, file: File): Resource<User> {

        ResponseToRequest.send(remoteDataSource.createWithImage(user, file)).run {
            return when(this) {
                is Resource.Success -> {
                    localDataSource.create(this.data.toUserEntity())
                    Resource.Success(this.data)
                }
                else -> {
                    Resource.Failure("Error Desconocido")
                }
            }
        }

    }

    override suspend fun delete(id: String): Resource<Unit> {
        ResponseToRequest.send(remoteDataSource.delete(id)).run {
            return when(this) {
                is Resource.Success -> {
                    localDataSource.delete(id)
                    Resource.Success(this.data)
                }
                else -> {
                    Resource.Failure("Error Desconocido")
                }
            }
        }
    }

    fun emitDataSource(usersLocal: List<UserEntity>) = flow {
        try {
            ResponseToRequest.send(remoteDataSource.getUsers()).run {
                when(this) {
                    is Resource.Success -> {
                        val usersRemote = this.data
                        val usersLocalMap = usersLocal.map { userEntity -> userEntity.toUser() }
                        localDataSource.createAll(this.data.map { user -> user.toUserEntity() })
                        emit(Resource.Success(this.data))
                    }
                    else -> {}
                }
            }
        } catch (e: Exception) {

        }
    }

}