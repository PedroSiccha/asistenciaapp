package com.inforad.asistenciaapp.domain.useCase.users

import com.inforad.asistenciaapp.domain.model.User
import com.inforad.asistenciaapp.domain.repository.UserRepository
import java.io.File

class CreateUserWithImageUseCase constructor(private val repository: UserRepository) {
    suspend operator fun invoke(user: User, file: File) = repository.createWithImage(user, file)
}