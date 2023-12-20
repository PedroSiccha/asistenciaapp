package com.inforad.asistenciaapp.di

import com.inforad.asistenciaapp.data.dataSource.local.datastore.AuthDatastore
import com.inforad.asistenciaapp.data.dataSource.local.AuthLocalDataSource
import com.inforad.asistenciaapp.data.dataSource.local.AuthLocalDataSourceImpl
import com.inforad.asistenciaapp.data.dataSource.local.ReunionLocalDataSource
import com.inforad.asistenciaapp.data.dataSource.local.ReunionLocalDataSourceImpl
import com.inforad.asistenciaapp.data.dataSource.local.UserLocalDataSource
import com.inforad.asistenciaapp.data.dataSource.local.UserLocalDataSourceImpl
import com.inforad.asistenciaapp.data.dataSource.local.dao.ReunionDao
import com.inforad.asistenciaapp.data.dataSource.local.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {
    @Provides
    fun provideAuthLocalDataSource(authDatastore: AuthDatastore): AuthLocalDataSource = AuthLocalDataSourceImpl(authDatastore)

    @Provides
    fun provideUserLocalDataSource(userDao: UserDao): UserLocalDataSource = UserLocalDataSourceImpl(userDao)

    @Provides
    fun provideReunionLocalDataSource(reunionDao: ReunionDao): ReunionLocalDataSource = ReunionLocalDataSourceImpl(reunionDao)
}