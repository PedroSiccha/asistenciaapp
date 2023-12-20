package com.inforad.asistenciaapp.data.dataSource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.inforad.asistenciaapp.data.dataSource.local.entity.ReunionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ReunionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(reunion: ReunionEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(reuniones: List<ReunionEntity>)

    @Query("SELECT * FROM reuniones")
    fun getReuniones(): Flow<List<ReunionEntity>>

    @Query("SELECT * FROM reuniones")
    fun getAllReuniones(): Flow<List<ReunionEntity>>

    @Query("SELECT * FROM reuniones WHERE estado = 'PENDIENTE' ORDER BY fecha DESC LIMIT 1")
    fun getLastReunion(): ReunionEntity

    @Query("UPDATE reuniones SET asunto = :asunto, detalle = :detalle, fecha = :fecha, estado = :estado WHERE id = :id" )
    suspend fun update(
        id: String,
        asunto: String,
        detalle: String,
        fecha: String,
        estado: String
    )

    @Query("UPDATE reuniones SET estado = :estado WHERE id = :id" )
    suspend fun cerrarReunion(
        id: String,
        estado: String
    )

    @Query("DELETE FROM reuniones WHERE id = :id")
    suspend fun delete(id: String)

}