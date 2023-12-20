package com.inforad.asistenciaapp.data.repository

import com.inforad.asistenciaapp.data.dataSource.local.AuthLocalDataSource
import com.inforad.asistenciaapp.data.dataSource.local.UserLocalDataSource
import com.inforad.asistenciaapp.data.dataSource.remote.AuthRemoteDataSource
import com.inforad.asistenciaapp.domain.model.AuthResponse
import com.inforad.asistenciaapp.domain.model.User
import com.inforad.asistenciaapp.domain.repository.AuthRepository
import com.inforad.asistenciaapp.domain.util.Resource
import com.inforad.asistenciaapp.domain.util.ResponseToRequest
import kotlinx.coroutines.flow.Flow

class AuthRepositoryImpl(
    private val authRemoteDataSource: AuthRemoteDataSource,
    private val authLocalDataSource: AuthLocalDataSource
    ): AuthRepository {
    override suspend fun login(dni: String, password: String): Resource<AuthResponse> = ResponseToRequest.send(
        authRemoteDataSource.login(dni, password)
    )

    override suspend fun register(user: User): Resource<AuthResponse> = ResponseToRequest.send(
        authRemoteDataSource.register(user)
    )

    override suspend fun saveSession(authResponse: AuthResponse) = authLocalDataSource.saveSession(authResponse)
    override suspend fun updateSession(user: User) = authLocalDataSource.updateSession(user)

    override suspend fun logout() = authLocalDataSource.logout()

    override fun getSessionData(): Flow<AuthResponse> = authLocalDataSource.getSessionData()

}