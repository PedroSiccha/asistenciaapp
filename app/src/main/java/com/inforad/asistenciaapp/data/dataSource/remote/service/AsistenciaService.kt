package com.inforad.asistenciaapp.data.dataSource.remote.service

import com.inforad.asistenciaapp.domain.model.Asistencia
import com.inforad.asistenciaapp.domain.model.Reunion
import com.inforad.asistenciaapp.domain.response.AsistenciaResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface AsistenciaService {
    @GET("asistencias")
    suspend fun getAsistencias(): Response<List<Asistencia>>

    @POST("asistencia/list/{id}")
    suspend fun getListAsistencia(
        @Path("id") id: String,
    ): Response<List<AsistenciaResponse>>

    @POST("asistencias/last")
    suspend fun getLastAsistencia(): Response<Asistencia>

    @POST("asistencia")
    suspend fun create(
        @Body asistencia: Asistencia
    ): Response<Asistencia>

    @PUT("asistencias/{id}")
    suspend fun update(
        @Path("id") id: String,
        @Body asistencia: Asistencia
    ): Response<Asistencia>

    @DELETE("asistencias/{id}")
    suspend fun delete(
        @Path("id") id: String,
    ): Response<Unit>
}