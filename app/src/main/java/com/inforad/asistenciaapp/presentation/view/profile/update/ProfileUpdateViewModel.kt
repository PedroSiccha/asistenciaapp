package com.inforad.asistenciaapp.presentation.view.profile.update

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inforad.asistenciaapp.domain.model.User
import com.inforad.asistenciaapp.domain.useCase.auth.AuthUseCase
import com.inforad.asistenciaapp.domain.useCase.users.UsersUseCase
import com.inforad.asistenciaapp.domain.util.Resource
import com.inforad.asistenciaapp.presentation.util.ComposeFileProvider
import com.inforad.asistenciaapp.presentation.util.ResultingActivityHandler
import com.inforad.asistenciaapp.presentation.view.profile.update.mapper.toUser
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class ProfileUpdateViewModel @Inject constructor(
    private val authUseCase: AuthUseCase,
    private val usersUseCase: UsersUseCase,
    private val savedStateHandle: SavedStateHandle,
    @ApplicationContext private val context: Context
): ViewModel() {
    var state by mutableStateOf(ProfileUpddateState())
        private set

    val data = savedStateHandle.get<String>("user")
    var user = User.fromJson(data!!)

    var file: File? = null
    val resultingActivityHandler = ResultingActivityHandler()

    var updateRespone by mutableStateOf<Resource<User>?>(null)
        private set

    init {
        state = state.copy(
            name = user.name,
            lastname = user.lastname,
            dni = user.dni,
            email = user.email ?: "",
            phone = user.phone,
            numeroPadron = user.numeroPadron,
            manzana = user.manzana,
            lote = user.lote,
            metros = user.metros,
            lotesDetalle = user.lotesDetalle,
            lotesCantidad = user.lotesCantidad,
            imagen = user.imagen ?: ""
        )
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

    fun onUpdate() {
        if (file != null) {
            updateWithImage()
        } else {
            update()
        }
    }

    fun updateWithImage() = viewModelScope.launch {
        updateRespone = Resource.Loading
        val result = usersUseCase.updateUserWithImage(user.id ?: "", state.toUser(), file!!)
        updateRespone = result
    }

    fun updateUserSession() = viewModelScope.launch {
        authUseCase.updateSession(state.toUser())
    }

    fun update() = viewModelScope.launch {
        updateRespone = Resource.Loading
        val result = usersUseCase.updateUser(user.id ?: "", state.toUser())
        updateRespone = result
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

    fun onPhoneInput(input: String) {
        state = state.copy(phone = input)
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

    fun onMetroInput(input: String) {
        state = state.copy(metros = input)
    }

    fun onLoteDetalleInput(input: String) {
        state = state.copy(lotesDetalle = input)
    }

    fun onLotesCantidadInput(input: String) {
        state = state.copy(lotesCantidad = input)
    }

}