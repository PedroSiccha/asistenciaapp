package com.inforad.asistenciaapp.data.dataSource.remote

import com.inforad.asistenciaapp.domain.model.Reunion
import com.inforad.asistenciaapp.domain.model.User
import retrofit2.Response
import java.io.File

interface UsersRemoteDataSource {
    suspend fun update(id: String, user: User): Response<User>
    suspend fun findByName(dato: String): Response<List<User>>
    suspend fun updateWithImage(id: String, user: User, file: File): Response<User>
    suspend fun createWithImage(user: User, file: File): Response<User>
    suspend fun getUsers(): Response<List<User>>
    suspend fun delete(id: String): Response<Unit>
}