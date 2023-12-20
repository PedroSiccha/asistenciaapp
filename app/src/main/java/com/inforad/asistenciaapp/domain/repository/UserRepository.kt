package com.inforad.asistenciaapp.domain.repository

import com.inforad.asistenciaapp.domain.model.Reunion
import com.inforad.asistenciaapp.domain.model.User
import com.inforad.asistenciaapp.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import java.io.File

interface UserRepository {
    suspend fun update(id: String, user: User): Resource<User>
    fun getUsers(): Flow<Resource<List<User>>>
    fun findByName(name: String): Flow<Resource<List<User>>>
    suspend fun updateWithImage(id: String, user: User, file: File): Resource<User>
    suspend fun createWithImage(user: User, file: File): Resource<User>
    suspend fun delete(id: String): Resource<Unit>
}