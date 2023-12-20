package com.inforad.asistenciaapp.di

import com.inforad.asistenciaapp.data.dataSource.remote.AsistenciasRemoteDataSource
import com.inforad.asistenciaapp.data.dataSource.remote.AuthRemoteDataSource
import com.inforad.asistenciaapp.data.dataSource.remote.ReporteRemoteDataSource
import com.inforad.asistenciaapp.data.dataSource.remote.ReunoinesRemoteDataSource
import com.inforad.asistenciaapp.data.dataSource.remote.UsersRemoteDataSource
import com.inforad.asistenciaapp.data.dataSource.remote.AsistenciasRemoteDataSpurceImpl
import com.inforad.asistenciaapp.data.dataSource.remote.AuthRemoteDataSourceImpl
import com.inforad.asistenciaapp.data.dataSource.remote.ReporteRemoteDataSourceImpl
import com.inforad.asistenciaapp.data.dataSource.remote.ReunionesRemoteDataSpurceImpl
import com.inforad.asistenciaapp.data.dataSource.remote.UsersRemoteDataSpurceImpl
import com.inforad.asistenciaapp.data.dataSource.remote.service.AsistenciaService
import com.inforad.asistenciaapp.data.dataSource.remote.service.AuthService
import com.inforad.asistenciaapp.data.dataSource.remote.service.ReporteService
import com.inforad.asistenciaapp.data.dataSource.remote.service.ReunionService
import com.inforad.asistenciaapp.data.dataSource.remote.service.UsersService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {
    @Provides
    fun provideAuthRemoteDataSource(authService: AuthService): AuthRemoteDataSource = AuthRemoteDataSourceImpl(authService)

    @Provides
    fun provideReporteRemoteDataSource(reporteService: ReporteService): ReporteRemoteDataSource = ReporteRemoteDataSourceImpl(reporteService)

    @Provides
    fun provideUsersRemoteDataSource(usersService: UsersService): UsersRemoteDataSource = UsersRemoteDataSpurceImpl(usersService)

    @Provides
    fun provideReunionesRemoteDataSource(reunionService: ReunionService): ReunoinesRemoteDataSource = ReunionesRemoteDataSpurceImpl(reunionService)

    @Provides
    fun provideAsistenciasRemoteDataSource(asistenciaService: AsistenciaService): AsistenciasRemoteDataSource = AsistenciasRemoteDataSpurceImpl(asistenciaService)
}