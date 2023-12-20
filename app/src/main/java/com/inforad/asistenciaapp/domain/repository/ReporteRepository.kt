package com.inforad.asistenciaapp.domain.repository

import com.inforad.asistenciaapp.domain.model.AuthResponse
import com.inforad.asistenciaapp.domain.model.User
import com.inforad.asistenciaapp.domain.response.AsistenciaReunionResponse
import com.inforad.asistenciaapp.domain.response.PromedioAsistenciaResponse
import com.inforad.asistenciaapp.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface ReporteRepository {
    suspend fun getPromAsistencia(): Resource<PromedioAsistenciaResponse>
    suspend fun getPromAsistenciaUsuario(id: String): Resource<PromedioAsistenciaResponse>
    suspend fun getReunionAsistenciaUsuario(id: String): Resource<AsistenciaReunionResponse>
}