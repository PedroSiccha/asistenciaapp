package com.inforad.asistenciaapp.presentation.view.auth.register

import android.content.Context
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inforad.asistenciaapp.domain.model.AuthResponse
import com.inforad.asistenciaapp.domain.model.User
import com.inforad.asistenciaapp.domain.useCase.auth.AuthUseCase
import com.inforad.asistenciaapp.domain.useCase.users.UsersUseCase
import com.inforad.asistenciaapp.domain.util.Resource
import com.inforad.asistenciaapp.presentation.util.ComposeFileProvider
import com.inforad.asistenciaapp.presentation.util.ResultingActivityHandler
import com.inforad.asistenciaapp.presentation.view.auth.register.mapper.toUser
import com.inforad.asistenciaapp.presentation.view.profile.update.mapper.toUser
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val authUseCase: AuthUseCase,
    private val usersUseCase: UsersUseCase,
    @ApplicationContext private val context: Context
    ): ViewModel() {

    var state by mutableStateOf(RegisterState())
        private set

    var errorMessage by mutableStateOf("")

    var registerResponse by mutableStateOf<Resource<AuthResponse>?>(null)
        private set

    var registerUserRespone by mutableStateOf<Resource<User>?>(null)
        private set

    var file: File? = null
    val resultingActivityHandler = ResultingActivityHandler()

    fun saveSession(authResponse: AuthResponse) = viewModelScope.launch {
        authUseCase.saveSession(authResponse)
    }

    fun pickImage() = viewModelScope.launch {
        val result = resultingActivityHandler.getContent("image/*")
        if (result != null) {
            file = ComposeFileProvider.createFileFromUri(context, result)
            state = state.copy(imagen = result.toString())
        }
    }

    fun takePhoto() = viewModelScope.launch {
        val result = resultingActivityHandler.takePicturePreview()
        if (result != null) {
            state = state.copy(imagen = ComposeFileProvider.getPathFromBitmap(context, result))
            file = File(state.imagen)
        }
    }

    fun onRegister() {
        if (file != null) {
            updateWithImage()
        } else {
            register()
        }
    }

    fun updateWithImage() = viewModelScope.launch {
        if (isValidForm()) {
            registerUserRespone = Resource.Loading
            val result = usersUseCase.createUserWithImage(state.toUser(), file!!)
            registerUserRespone = result
        }
    }

    fun register() = viewModelScope.launch {
        if (isValidForm()) {
            registerResponse = Resource.Loading
            val result = authUseCase.register(state.toUser())
            registerResponse = result
        }
    }

    fun msgSuccess() {
        Toast.makeText(context, "El usuario ${ state.name }, con número de padrón ${ state.numeroPadron } \n SE GUARDÓ CORRECTAMENTE", Toast.LENGTH_LONG).show()
    }

    fun onNameInput(input: String) {
        state = state.copy(name = input)
    }

    fun onLastnameInput(input: String) {
        state = state.copy(lastname = input)
    }

    fun onDniInput(input: String) {
        state = state.copy(dni = input)
    }

    fun onEmailInput(input: String) {
        state = state.copy(email = input)
    }

    fun onTelefonoInput(input: String) {
        state = state.copy(telefono = input)
    }

    fun onNumeroPadronInput(input: Int) {
        state = state.copy(numeroPadron = input)
    }

    fun onManzanaInput(input: String) {
        state = state.copy(manzana = input)
    }

    fun onLoteInput(input: Int) {
        state = state.copy(lote = input)
    }

    fun onMetrosInput(input: String) {
        state = state.copy(metros = input)
    }

    fun onLotesDetallesInput(input: String) {
        state = state.copy(lotesDetalle = input)
    }

    fun onLotesCantidadInput(input: String) {
        state = state.copy(lotesCantidad = input)
    }

    fun isValidForm(): Boolean {
        if (state.name == "") {
            errorMessage = "Ingrese el nombre"
            return false
        }
        else if (state.lastname == "") {
            errorMessage = "Ingrese su apellido"
            return false
        }
        else if (state.dni == "") {
            errorMessage = "Ingrese su DNI"
            return false
        }
        else if (state.numeroPadron == null) {
            errorMessage = "Ingrese su Número de Padrón"
            return false
        }
        return true
    }
}