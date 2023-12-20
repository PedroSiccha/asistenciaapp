package com.inforad.asistenciaapp.data.repository

import com.inforad.asistenciaapp.data.dataSource.remote.AsistenciasRemoteDataSource
import com.inforad.asistenciaapp.domain.model.Asistencia
import com.inforad.asistenciaapp.domain.repository.AsistenciaRepository
import com.inforad.asistenciaapp.domain.response.AsistenciaResponse
import com.inforad.asistenciaapp.domain.util.Resource
import com.inforad.asistenciaapp.domain.util.ResponseToRequest
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class AsistenciasRepositoryImpl(private val asistenciasRemoteDataSource: AsistenciasRemoteDataSource): AsistenciaRepository {
    override suspend fun create(asistencia: Asistencia): Resource<Asistencia> = ResponseToRequest.send(
        asistenciasRemoteDataSource.create(asistencia)
    )

    override suspend fun getLastAsistencia(): Resource<Asistencia> = ResponseToRequest.send(
        asistenciasRemoteDataSource.getLastAsistencias()
    )

    override fun getAsistencia(id: String): Flow<Resource<List<AsistenciaResponse>>> = callbackFlow {
        trySend(ResponseToRequest.send(asistenciasRemoteDataSource.getAsistencias(id)))
        awaitClose {
            cancel()
        }
    }

    override suspend fun update(id: String, asistencia: Asistencia): Resource<Asistencia> {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: String): Resource<Unit> {
        TODO("Not yet implemented")
    }
}