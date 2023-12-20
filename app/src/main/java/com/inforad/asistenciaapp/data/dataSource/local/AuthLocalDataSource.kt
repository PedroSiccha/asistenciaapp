package com.inforad.asistenciaapp.data.dataSource.local

import com.inforad.asistenciaapp.domain.model.AuthResponse
import com.inforad.asistenciaapp.domain.model.User
import kotlinx.coroutines.flow.Flow

interface AuthLocalDataSource {
    suspend fun saveSession(authResponse: AuthResponse)
    suspend fun updateSession(user: User)
    suspend fun logout()
    fun getSessionData(): Flow<AuthResponse>
}