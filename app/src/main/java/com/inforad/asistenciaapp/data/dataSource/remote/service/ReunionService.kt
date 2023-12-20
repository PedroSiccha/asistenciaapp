package com.inforad.asistenciaapp.data.dataSource.remote.service

import com.inforad.asistenciaapp.domain.model.EstadoReunion
import com.inforad.asistenciaapp.domain.model.Reunion
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

interface ReunionService {

    @GET("reuniones")
    suspend fun getReuniones(): Response<List<Reunion>>

    @GET("reuniones/all")
    suspend fun getAllReuniones(): Response<List<Reunion>>

    @GET("reuniones/last")
    suspend fun getLastReunion(): Response<Reunion>

    @POST("reuniones")
    suspend fun create(
        @Body reunion: Reunion
    ): Response<Reunion>

    @PUT("reuniones/{id}")
    suspend fun update(
        @Path("id") id: String,
        @Body reunion: Reunion
    ): Response<Reunion>

    @PUT("reuniones/close/{id}")
    suspend fun cerrarReunion(
        @Path("id") id: String,
        @Body estado: EstadoReunion,
    ): Response<Reunion>

    @DELETE("reuniones/{id}")
    suspend fun delete(
        @Path("id") id: String,
    ): Response<Unit>
}