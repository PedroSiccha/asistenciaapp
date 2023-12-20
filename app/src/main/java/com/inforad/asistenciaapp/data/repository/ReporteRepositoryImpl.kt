package com.inforad.asistenciaapp.data.repository

import com.inforad.asistenciaapp.data.dataSource.remote.ReporteRemoteDataSource
import com.inforad.asistenciaapp.domain.repository.ReporteRepository
import com.inforad.asistenciaapp.domain.response.AsistenciaReunionResponse
import com.inforad.asistenciaapp.domain.response.PromedioAsistenciaResponse
import com.inforad.asistenciaapp.domain.util.Resource
import com.inforad.asistenciaapp.domain.util.ResponseToRequest

class ReporteRepositoryImpl(
    private val reporteRemoteDataSource: ReporteRemoteDataSource
    ): ReporteRepository {

    override suspend fun getPromAsistencia(): Resource<PromedioAsistenciaResponse> = ResponseToRequest.send(
        reporteRemoteDataSource.getPromAsistencia()
    )

    override suspend fun getPromAsistenciaUsuario(id: String): Resource<PromedioAsistenciaResponse> = ResponseToRequest.send(
        reporteRemoteDataSource.getPromAsistenciaUsuario(id)
    )

    override suspend fun getReunionAsistenciaUsuario(id: String): Resource<AsistenciaReunionResponse> = ResponseToRequest.send(
        reporteRemoteDataSource.getReunionAsistenciaUsuario(id)
    )

}