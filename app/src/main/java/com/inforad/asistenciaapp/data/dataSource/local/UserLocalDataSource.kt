package com.inforad.asistenciaapp.data.dataSource.local

import com.inforad.asistenciaapp.data.dataSource.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

interface UserLocalDataSource {
    suspend fun create(user: UserEntity)
    suspend fun createAll(users: List<UserEntity>)
    fun getUsers(): Flow<List<UserEntity>>
    suspend fun update(id: String, name: String, lastname: String, dni: String, email: String, phone: String, numero_padron: String, manzana: String, metros: String, lotes_detalle: String, image: String)
    suspend fun delete(id: String)
}