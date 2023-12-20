package com.inforad.asistenciaapp.di

import com.inforad.asistenciaapp.data.repository.AsistenciasRepositoryImpl
import com.inforad.asistenciaapp.data.repository.AuthRepositoryImpl
import com.inforad.asistenciaapp.data.repository.ReporteRepositoryImpl
import com.inforad.asistenciaapp.data.repository.ReunionesRepositoryImpl
import com.inforad.asistenciaapp.data.repository.UsersRepositoryImpl
import com.inforad.asistenciaapp.data.dataSource.remote.AsistenciasRemoteDataSource
import com.inforad.asistenciaapp.data.dataSource.local.AuthLocalDataSource
import com.inforad.asistenciaapp.data.dataSource.local.ReunionLocalDataSource
import com.inforad.asistenciaapp.data.dataSource.local.UserLocalDataSource
import com.inforad.asistenciaapp.data.dataSource.remote.AuthRemoteDataSource
import com.inforad.asistenciaapp.data.dataSource.remote.ReporteRemoteDataSource
import com.inforad.asistenciaapp.data.dataSource.remote.ReunoinesRemoteDataSource
import com.inforad.asistenciaapp.data.dataSource.remote.UsersRemoteDataSource
import com.inforad.asistenciaapp.domain.repository.AsistenciaRepository
import com.inforad.asistenciaapp.domain.repository.AuthRepository
import com.inforad.asistenciaapp.domain.repository.ReporteRepository
import com.inforad.asistenciaapp.domain.repository.ReunionRepository
import com.inforad.asistenciaapp.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideAuthRepository(authRemoteDataSource: AuthRemoteDataSource, authLocalDataSource: AuthLocalDataSource): AuthRepository = AuthRepositoryImpl(authRemoteDataSource, authLocalDataSource)

    @Provides
    fun provideReporteRepository(reporteRemoteDataSource: ReporteRemoteDataSource): ReporteRepository = ReporteRepositoryImpl(reporteRemoteDataSource)

    @Provides
    fun provideUserRepository(
        usersRemoteDataSource: UsersRemoteDataSource,
        userLocalDataSource: UserLocalDataSource
    ): UserRepository = UsersRepositoryImpl(usersRemoteDataSource, userLocalDataSource)

    @Provides
    fun provideReunionesRepository(
        reunionesRemoteDataSource: ReunoinesRemoteDataSource,
        reunionLocalDataSource: ReunionLocalDataSource
    ): ReunionRepository = ReunionesRepositoryImpl(reunionesRemoteDataSource, reunionLocalDataSource)

    @Provides
    fun provideAsistenciasRepository(asistenciasRemoteDataSource: AsistenciasRemoteDataSource): AsistenciaRepository = AsistenciasRepositoryImpl(asistenciasRemoteDataSource)
}