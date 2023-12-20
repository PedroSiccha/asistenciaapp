package com.inforad.asistenciaapp.data.dataSource.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.inforad.asistenciaapp.data.dataSource.local.dao.ReunionDao
import com.inforad.asistenciaapp.data.dataSource.local.dao.UserDao
import com.inforad.asistenciaapp.data.dataSource.local.entity.ReunionEntity
import com.inforad.asistenciaapp.data.dataSource.local.entity.UserEntity

@Database(
    entities = [UserEntity::class, ReunionEntity::class],
    version = 2,
    exportSchema = false
)
abstract class AsistenciaDB: RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun reunionDao(): ReunionDao
}