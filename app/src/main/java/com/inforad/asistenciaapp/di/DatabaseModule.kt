package com.inforad.asistenciaapp.di

import android.app.Application
import androidx.room.Room
import com.inforad.asistenciaapp.data.dataSource.local.dao.ReunionDao
import com.inforad.asistenciaapp.data.dataSource.local.dao.UserDao
import com.inforad.asistenciaapp.data.dataSource.local.db.AsistenciaDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesDatabase(app: Application): AsistenciaDB = Room.databaseBuilder(app, AsistenciaDB::class.java, "asistencia_db").fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun providesUserDao(db: AsistenciaDB): UserDao = db.userDao()

    @Provides
    @Singleton
    fun providesReunionDao(db: AsistenciaDB): ReunionDao = db.reunionDao()

}