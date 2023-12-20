package com.inforad.asistenciaapp.presentation.view.profile.detalleback

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.inforad.asistenciaapp.domain.model.User
import com.inforad.asistenciaapp.domain.useCase.auth.AuthUseCase
import com.inforad.asistenciaapp.domain.useCase.users.UsersUseCase
import com.inforad.asistenciaapp.domain.util.Resource
import com.itextpdf.text.*
import com.itextpdf.text.pdf.PdfWriter
import dagger.hilt.android.lifecycle.HiltViewModel
import java.io.FileNotFoundException
import javax.inject.Inject
import com.itextpdf.text.Document
import android.os.Environment
import com.inforad.asistenciaapp.presentation.view.profile.detalleback.ProfileDetalleBackState
import java.io.File
import java.io.FileOutputStream

@HiltViewModel
class ProfileDetalleBackViewModel @Inject constructor(
    private val authUseCase: AuthUseCase,
    private val usersUseCase: UsersUseCase,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {
    var state by mutableStateOf(ProfileDetalleBackState())
        private set

    val data = savedStateHandle.get<String>("user")
    var user = User.fromJson(data!!)

    init {
        state = state.copy(
            name = user.name,
            lastname = user.lastname,
            phone = user.phone,
            dni = user.dni,
            email = user.email!!,
            numeroPadron = user.numeroPadron,
            lote = user.lote,
            manzana = user.manzana
        )
    }
}