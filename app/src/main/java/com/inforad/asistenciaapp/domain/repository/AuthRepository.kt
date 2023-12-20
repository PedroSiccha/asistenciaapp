package com.inforad.asistenciaapp.domain.repository

import com.inforad.asistenciaapp.domain.model.AuthResponse
import com.inforad.asistenciaapp.domain.model.User
import com.inforad.asistenciaapp.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun login(dni: String, password: String): Resource<AuthResponse>
    suspend fun register(user: User): Resource<AuthResponse>
    suspend fun saveSession(authResponse: AuthResponse)
    suspend fun updateSession(user: User)
    suspend fun logout()
    fun getSessionData(): Flow<AuthResponse>
}