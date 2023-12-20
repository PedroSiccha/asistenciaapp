package com.inforad.asistenciaapp.domain.useCase.reuniones

data class ReunionesUseCase(
    val createReunion: CreateReunionesUseCase,
    val getReunion: GetReunionesUseCase,
    val updateReunion: UpdateReunionesUseCase,
    val getLastReunion: GetLastReunionUseCase,
    val cerrarReunion: CerrarReunionUseCase,
    val getAllReuniones: GetAllReunionesUseCase
)
