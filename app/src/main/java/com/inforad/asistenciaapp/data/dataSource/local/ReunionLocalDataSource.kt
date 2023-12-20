package com.inforad.asistenciaapp.data.dataSource.local

import com.inforad.asistenciaapp.data.dataSource.local.entity.ReunionEntity
import kotlinx.coroutines.flow.Flow

interface ReunionLocalDataSource {
    suspend fun create(reunion: ReunionEntity)
    suspend fun createAll(reuniones: List<ReunionEntity>)
    fun getReuniones(): Flow<List<ReunionEntity>>
    fun getAllReuniones(): Flow<List<ReunionEntity>>
    fun getLastReunion(): ReunionEntity
    suspend fun update(id: String, asunto: String, detalle: String, fecha: String, estado: String)
    suspend fun cerrrarReunion(id: String, estado: String)
    suspend fun delete(id: String)
}