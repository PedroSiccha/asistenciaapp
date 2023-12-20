package com.inforad.asistenciaapp.domain.useCase.auth

data class AuthUseCase(
    val login: LoginUseCase,
    val register: RegisterUseCase,
    val saveSession: SaveSessionUseCase,
    val updateSession: UpdateSessionUseCase,
    val getSessionData: GetSessionDataUseCase,
    val logout: LogoutUseCase
)
