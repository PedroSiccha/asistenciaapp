package com.inforad.asistenciaapp.data.dataSource.remote

import com.inforad.asistenciaapp.data.dataSource.remote.ReporteRemoteDataSource
import com.inforad.asistenciaapp.data.dataSource.remote.service.ReporteService
import com.inforad.asistenciaapp.domain.response.AsistenciaReunionResponse
import com.inforad.asistenciaapp.domain.response.PromedioAsistenciaResponse
import retrofit2.Response

class ReporteRemoteDataSourceImpl(private val reporteService: ReporteService):
    ReporteRemoteDataSource {
    //Admin
    override suspend fun getPromAsistencia(): Response<PromedioAsistenciaResponse> = reporteService.getPromAsistencia()

    //Coll
    override suspend fun getPromAsistenciaUsuario(id: String): Response<PromedioAsistenciaResponse> = reporteService.getPromAsistenciaUsuario(id)
    override suspend fun getReunionAsistenciaUsuario(id: String): Response<AsistenciaReunionResponse> = reporteService.getReunionAsistenciaUsuario(id)
}