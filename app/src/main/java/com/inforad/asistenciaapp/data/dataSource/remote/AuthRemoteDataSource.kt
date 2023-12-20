package com.inforad.asistenciaapp.data.dataSource.remote

import com.inforad.asistenciaapp.domain.model.AuthResponse
import com.inforad.asistenciaapp.domain.model.User
import retrofit2.Response

interface AuthRemoteDataSource {
    suspend fun login(dni: String, password: String): Response<AuthResponse>
    suspend fun register(user: User): Response<AuthResponse>
}