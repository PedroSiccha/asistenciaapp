package com.inforad.asistenciaapp.data.dataSource.local

import com.inforad.asistenciaapp.data.dataSource.local.datastore.AuthDatastore
import com.inforad.asistenciaapp.data.dataSource.local.AuthLocalDataSource
import com.inforad.asistenciaapp.domain.model.AuthResponse
import com.inforad.asistenciaapp.domain.model.User
import kotlinx.coroutines.flow.Flow

class AuthLocalDataSourceImpl constructor(private val authDatastore: AuthDatastore):
    AuthLocalDataSource {
    override suspend fun saveSession(authResponse: AuthResponse) = authDatastore.saveUser(authResponse)
    override suspend fun updateSession(user: User) = authDatastore.updateUser(user)
    override suspend fun logout() = authDatastore.delete()
    override fun getSessionData(): Flow<AuthResponse> = authDatastore.getData()
}