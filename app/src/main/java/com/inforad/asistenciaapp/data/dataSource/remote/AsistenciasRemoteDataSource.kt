package com.inforad.asistenciaapp.data.dataSource.remote

import com.inforad.asistenciaapp.domain.model.Asistencia
import com.inforad.asistenciaapp.domain.response.AsistenciaResponse
import retrofit2.Response

interface AsistenciasRemoteDataSource {
    suspend fun create(asistencia: Asistencia): Response<Asistencia>
    suspend fun getLastAsistencias(): Response<Asistencia>
    suspend fun getAsistencias(id: String): Response<List<AsistenciaResponse>>
    suspend fun update(id: String, asistencia: Asistencia): Response<Asistencia>
    suspend fun delete(id: String): Response<Unit>
}