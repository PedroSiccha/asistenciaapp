package com.inforad.asistenciaapp.data.dataSource.remote

import com.inforad.asistenciaapp.data.dataSource.remote.AsistenciasRemoteDataSource
import com.inforad.asistenciaapp.data.dataSource.remote.service.AsistenciaService
import com.inforad.asistenciaapp.domain.model.Asistencia
import com.inforad.asistenciaapp.domain.response.AsistenciaResponse
import retrofit2.Response

class AsistenciasRemoteDataSpurceImpl(private val asistenciaService: AsistenciaService):
    AsistenciasRemoteDataSource {
    override suspend fun create(asistencia: Asistencia): Response<Asistencia> = asistenciaService.create(asistencia)

    override suspend fun getLastAsistencias(): Response<Asistencia> = asistenciaService.getLastAsistencia()

    override suspend fun getAsistencias(id: String): Response<List<AsistenciaResponse>> = asistenciaService.getListAsistencia(id)

    override suspend fun update(id: String, asistencia: Asistencia): Response<Asistencia> {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: String): Response<Unit> {
        TODO("Not yet implemented")
    }

}