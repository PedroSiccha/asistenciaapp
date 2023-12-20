package com.inforad.asistenciaapp.domain.repository

import com.inforad.asistenciaapp.domain.model.EstadoReunion
import com.inforad.asistenciaapp.domain.model.Reunion
import com.inforad.asistenciaapp.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface ReunionRepository {
    suspend fun create(reunion: Reunion): Resource<Reunion>
    fun getReuniones(): Flow<Resource<List<Reunion>>>
    fun getAllReuniones(): Flow<Resource<List<Reunion>>>
    suspend fun getLastReunion(): Resource<Reunion>
    suspend fun update(id: String, reunion: Reunion): Resource<Reunion>
    suspend fun cerrarReunion(id: String, estado: EstadoReunion): Resource<Reunion>
    suspend fun delete(id: String): Resource<Unit>
}