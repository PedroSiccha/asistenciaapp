package com.inforad.asistenciaapp.data.dataSource.remote.service

import com.inforad.asistenciaapp.domain.model.Asistencia
import com.inforad.asistenciaapp.domain.model.Reunion
import com.inforad.asistenciaapp.domain.response.AsistenciaResponse
import com.inforad.asistenciaapp.domain.response.AsistenciaReunionResponse
import com.inforad.asistenciaapp.domain.response.PromedioAsistenciaResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ReporteService {

    @GET("asistencia/reportePromAsistencia")
    suspend fun getPromAsistencia(): Response<PromedioAsistenciaResponse>

    @POST("asistencia/reportePromAsistenciaUsuario/{id}")
    suspend fun getPromAsistenciaUsuario(
        @Path("id") id: String,
    ): Response<PromedioAsistenciaResponse>

    @POST("asistencia/obtenerReunionesAsistidasPorUsuario/{id}")
    suspend fun getReunionAsistenciaUsuario(
        @Path("id") id: String,
    ): Response<AsistenciaReunionResponse>

}