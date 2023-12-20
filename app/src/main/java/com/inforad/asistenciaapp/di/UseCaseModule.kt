package com.inforad.asistenciaapp.di

import com.inforad.asistenciaapp.domain.repository.AsistenciaRepository
import com.inforad.asistenciaapp.domain.repository.AuthRepository
import com.inforad.asistenciaapp.domain.repository.ReporteRepository
import com.inforad.asistenciaapp.domain.repository.ReunionRepository
import com.inforad.asistenciaapp.domain.repository.UserRepository
import com.inforad.asistenciaapp.domain.useCase.asistencias.AsistenciaUseCase
import com.inforad.asistenciaapp.domain.useCase.asistencias.CreateAsistenciaUseCase
import com.inforad.asistenciaapp.domain.useCase.asistencias.GetAsistenciaUseCase
import com.inforad.asistenciaapp.domain.useCase.asistencias.LastAsistenciaUseCase
import com.inforad.asistenciaapp.domain.useCase.auth.*
import com.inforad.asistenciaapp.domain.useCase.reporte.PromedioAsistenciaUseCase
import com.inforad.asistenciaapp.domain.useCase.reporte.PromedioAsistenciaUsuarioUseCase
import com.inforad.asistenciaapp.domain.useCase.reporte.ReporteUseCase
import com.inforad.asistenciaapp.domain.useCase.reporte.ReunionAsistenciaUseCase
import com.inforad.asistenciaapp.domain.useCase.reuniones.CerrarReunionUseCase
import com.inforad.asistenciaapp.domain.useCase.reuniones.CreateReunionesUseCase
import com.inforad.asistenciaapp.domain.useCase.reuniones.GetAllReunionesUseCase
import com.inforad.asistenciaapp.domain.useCase.reuniones.GetLastReunionUseCase
import com.inforad.asistenciaapp.domain.useCase.reuniones.GetReunionesUseCase
import com.inforad.asistenciaapp.domain.useCase.reuniones.ReunionesUseCase
import com.inforad.asistenciaapp.domain.useCase.reuniones.UpdateReunionesUseCase
import com.inforad.asistenciaapp.domain.useCase.users.CreateUserWithImageUseCase
import com.inforad.asistenciaapp.domain.useCase.users.DeleteUserUseCase
import com.inforad.asistenciaapp.domain.useCase.users.FindByUsersUseCase
import com.inforad.asistenciaapp.domain.useCase.users.GetUsersUseCase
import com.inforad.asistenciaapp.domain.useCase.users.UpdateUserUseCase
import com.inforad.asistenciaapp.domain.useCase.users.UpdateUserWithImageUseCase
import com.inforad.asistenciaapp.domain.useCase.users.UsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository) = AuthUseCase(
        login = LoginUseCase(authRepository),
        register = RegisterUseCase(authRepository),
        saveSession = SaveSessionUseCase(authRepository),
        updateSession = UpdateSessionUseCase(authRepository),
        getSessionData = GetSessionDataUseCase(authRepository),
        logout = LogoutUseCase(authRepository)
    )

    @Provides
    fun provideReporteUseCase(reporteRepository: ReporteRepository) = ReporteUseCase(
        promedioAsistencia = PromedioAsistenciaUseCase(reporteRepository),
        promedioAsistenciaUsuario = PromedioAsistenciaUsuarioUseCase(reporteRepository),
        reunionAsistencia = ReunionAsistenciaUseCase(reporteRepository)
    )

    @Provides
    fun provideUserUseCase(userRepository: UserRepository) = UsersUseCase(
        updateUser = UpdateUserUseCase(userRepository),
        getUser = GetUsersUseCase(userRepository),
        updateUserWithImage = UpdateUserWithImageUseCase(userRepository),
        createUserWithImage = CreateUserWithImageUseCase(userRepository),
        findByName = FindByUsersUseCase(userRepository),
        deleteUser = DeleteUserUseCase(userRepository)
    )

    @Provides
    fun provideReunionesUseCase(reunionRepository: ReunionRepository) = ReunionesUseCase(
        createReunion = CreateReunionesUseCase(reunionRepository),
        getReunion = GetReunionesUseCase(reunionRepository),
        updateReunion = UpdateReunionesUseCase(reunionRepository),
        getLastReunion = GetLastReunionUseCase(reunionRepository),
        cerrarReunion = CerrarReunionUseCase(reunionRepository),
        getAllReuniones = GetAllReunionesUseCase(reunionRepository)
    )

    @Provides
    fun provideAsistenciaUseCase(asistenciaRepository: AsistenciaRepository) = AsistenciaUseCase(
        createUseCase = CreateAsistenciaUseCase(asistenciaRepository),
        lastAsistenciaUseCase = LastAsistenciaUseCase(asistenciaRepository),
        getAsistencia = GetAsistenciaUseCase(asistenciaRepository)
    )
}