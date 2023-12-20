package com.inforad.asistenciaapp.presentation.view.auth.login

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inforad.asistenciaapp.domain.model.AuthResponse
import com.inforad.asistenciaapp.domain.useCase.auth.AuthUseCase
import com.inforad.asistenciaapp.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCase: AuthUseCase): ViewModel() {
    var state by mutableStateOf(LoginState())
        private set

    var errorMessage by mutableStateOf("")

    var loginResource by mutableStateOf<Resource<AuthResponse>?>(null)
        private set

    init {
        getSessionData()
    }

    fun getSessionData() = viewModelScope.launch {
        authUseCase.getSessionData().collect() { data ->
            if (!data.token.isNullOrBlank()) {
                loginResource = Resource.Success(data)
            }
        }
    }

    fun saveSession(authResponse: AuthResponse) = viewModelScope.launch {
        authUseCase.saveSession(authResponse)
    }

    fun login() = viewModelScope.launch {
        if (isValidForm()) {
            loginResource = Resource.Loading
            val result = authUseCase.login(state.dni, state.password)
            loginResource = result
        }

    }

    fun onDniInput(dni: String) {
        state = state.copy(dni = dni)
    }

    fun onPasswordInput(password: String) {
        state = state.copy(password = password)
    }

    fun isValidForm(): Boolean {
        if (state.password.length < 6) {
            errorMessage = "La contraseña debe tener al menos 6 caracteres"
            return false
        }
        return true
    }
}