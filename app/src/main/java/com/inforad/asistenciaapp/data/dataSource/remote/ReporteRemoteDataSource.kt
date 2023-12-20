package com.inforad.asistenciaapp.data.dataSource.remote

import com.inforad.asistenciaapp.domain.model.AuthResponse
import com.inforad.asistenciaapp.domain.model.User
import com.inforad.asistenciaapp.domain.response.AsistenciaResponse
import com.inforad.asistenciaapp.domain.response.AsistenciaReunionResponse
import com.inforad.asistenciaapp.domain.response.PromedioAsistenciaResponse
import retrofit2.Response

interface ReporteRemoteDataSource {
    //Admin
    suspend fun getPromAsistencia(): Response<PromedioAsistenciaResponse>

    //Coll
    suspend fun getPromAsistenciaUsuario(id: String): Response<PromedioAsistenciaResponse>
    suspend fun getReunionAsistenciaUsuario(id: String): Response<AsistenciaReunionResponse>
}