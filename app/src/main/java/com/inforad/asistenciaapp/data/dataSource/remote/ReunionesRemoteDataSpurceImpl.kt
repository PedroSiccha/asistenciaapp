package com.inforad.asistenciaapp.data.dataSource.remote

import com.inforad.asistenciaapp.data.dataSource.remote.ReunoinesRemoteDataSource
import com.inforad.asistenciaapp.data.dataSource.remote.service.ReunionService
import com.inforad.asistenciaapp.domain.model.EstadoReunion
import com.inforad.asistenciaapp.domain.model.Reunion
import retrofit2.Response

class ReunionesRemoteDataSpurceImpl(private val reunionService: ReunionService):
    ReunoinesRemoteDataSource {
    override suspend fun create(reunion: Reunion): Response<Reunion> = reunionService.create(reunion)

    override suspend fun getReuniones(): Response<List<Reunion>> = reunionService.getReuniones()
    override suspend fun getAllReuniones(): Response<List<Reunion>> = reunionService.getAllReuniones()

    override suspend fun getLastReunion(): Response<Reunion> = reunionService.getLastReunion()

    override suspend fun update(id: String, reunion: Reunion): Response<Reunion> {
        TODO("Not yet implemented")
    }

    override suspend fun cerrarReunion(id: String, estado: EstadoReunion): Response<Reunion> = reunionService.cerrarReunion(id, estado)

    override suspend fun delete(id: String): Response<Unit> {
        TODO("Not yet implemented")
    }

}