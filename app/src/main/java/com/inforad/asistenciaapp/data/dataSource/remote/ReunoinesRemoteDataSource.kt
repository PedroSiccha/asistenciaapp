package com.inforad.asistenciaapp.data.dataSource.remote

import com.inforad.asistenciaapp.domain.model.EstadoReunion
import com.inforad.asistenciaapp.domain.model.Reunion
import retrofit2.Response

interface ReunoinesRemoteDataSource {
    suspend fun create(reunion: Reunion): Response<Reunion>
    suspend fun getReuniones(): Response<List<Reunion>>
    suspend fun getAllReuniones(): Response<List<Reunion>>
    suspend fun getLastReunion(): Response<Reunion>
    suspend fun update(id: String, reunion: Reunion): Response<Reunion>
    suspend fun cerrarReunion(id: String, estado: EstadoReunion): Response<Reunion>
    suspend fun delete(id: String): Response<Unit>
}