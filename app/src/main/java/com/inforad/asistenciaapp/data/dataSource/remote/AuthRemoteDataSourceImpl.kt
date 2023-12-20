package com.inforad.asistenciaapp.data.dataSource.remote

import com.inforad.asistenciaapp.data.dataSource.remote.AuthRemoteDataSource
import com.inforad.asistenciaapp.data.dataSource.remote.service.AuthService
import com.inforad.asistenciaapp.domain.model.AuthResponse
import com.inforad.asistenciaapp.domain.model.User
import retrofit2.Response

class AuthRemoteDataSourceImpl(private val authService: AuthService): AuthRemoteDataSource {
    override suspend fun login(dni: String, password: String) = authService.login(dni, password)
    override suspend fun register(user: User): Response<AuthResponse> = authService.register(user)
}