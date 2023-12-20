package com.inforad.asistenciaapp.domain.useCase.users

data class UsersUseCase(
    val updateUser: UpdateUserUseCase,
    val getUser: GetUsersUseCase,
    val updateUserWithImage: UpdateUserWithImageUseCase,
    val createUserWithImage: CreateUserWithImageUseCase,
    val findByName: FindByUsersUseCase,
    val deleteUser: DeleteUserUseCase
)
