package com.inforad.asistenciaapp.domain.repository

import com.inforad.asistenciaapp.domain.model.Asistencia
import com.inforad.asistenciaapp.domain.response.AsistenciaResponse
import com.inforad.asistenciaapp.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface AsistenciaRepository {
    suspend fun create(asistencia: Asistencia): Resource<Asistencia>
    suspend fun getLastAsistencia(): Resource<Asistencia>
    fun getAsistencia(id: String): Flow<Resource<List<AsistenciaResponse>>>
    suspend fun update(id: String, asistencia: Asistencia): Resource<Asistencia>
    suspend fun delete(id: String): Resource<Unit>
}