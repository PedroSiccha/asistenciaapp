package com.inforad.asistenciaapp.data.dataSource.local

import com.inforad.asistenciaapp.data.dataSource.local.dao.ReunionDao
import com.inforad.asistenciaapp.data.dataSource.local.entity.ReunionEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking

class ReunionLocalDataSourceImpl(private val reunionDao: ReunionDao): ReunionLocalDataSource {
    override suspend fun create(reunion: ReunionEntity) = reunionDao.insert(reunion)
    override suspend fun createAll(reuniones: List<ReunionEntity>) = reunionDao.insertAll(reuniones)

    override fun getReuniones(): Flow<List<ReunionEntity>> = reunionDao.getReuniones()
    override fun getAllReuniones(): Flow<List<ReunionEntity>> = reunionDao.getAllReuniones()
    override fun getLastReunion(): ReunionEntity = runBlocking(Dispatchers.IO) {
        reunionDao.getLastReunion()
    }

    override suspend fun update(
        id: String,
        asunto: String,
        detalle: String,
        fecha: String,
        estado: String
    ) = reunionDao.update(id, asunto, detalle, fecha, estado)

    override suspend fun cerrrarReunion(id: String, estado: String) = reunionDao.cerrarReunion(id, estado)

    override suspend fun delete(id: String) = reunionDao.delete(id)

}