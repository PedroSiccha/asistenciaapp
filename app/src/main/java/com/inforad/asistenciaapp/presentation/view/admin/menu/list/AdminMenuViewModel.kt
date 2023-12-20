package com.inforad.asistenciaapp.presentation.view.admin.menu.list

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inforad.asistenciaapp.domain.model.Reunion
import com.inforad.asistenciaapp.domain.model.ReunionResponse
import com.inforad.asistenciaapp.domain.model.User
import com.inforad.asistenciaapp.domain.useCase.asistencias.AsistenciaUseCase
import com.inforad.asistenciaapp.domain.useCase.asistencias.LastAsistenciaUseCase
import com.inforad.asistenciaapp.domain.useCase.auth.AuthUseCase
import com.inforad.asistenciaapp.domain.useCase.reuniones.ReunionesUseCase
import com.inforad.asistenciaapp.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdminMenuViewModel
@Inject constructor(
    private val authUseCase: AuthUseCase,
    private val reunionesUseCase: ReunionesUseCase
    ): ViewModel() {

    var user by mutableStateOf<User?>(null)
        private set

    var reunionesResponse by mutableStateOf<Resource<List<Reunion>>?>(null)
        private set

    var lastReunionResponse by mutableStateOf<Reunion?>(null)
        private set

    init {
        getSessionData()
        getReuniones()
        getLastReunion()
    }
    fun getSessionData() = viewModelScope.launch {
        authUseCase.getSessionData().collect() {data ->
            user = data.user
        }
    }

    fun getReuniones() = viewModelScope.launch {
        reunionesResponse = Resource.Loading
        reunionesUseCase.getReunion().collect() {data ->
            reunionesResponse = data
        }
    }

    fun getLastReunion() = viewModelScope.launch {
        //lastReunionResponse = Resource.Loading
        try {
            val result = reunionesUseCase.getLastReunion()
            when (result) {
                is Resource.Success -> {
                    lastReunionResponse = result?.data
                    Log.e("lastReunionResponse", lastReunionResponse.toString())
                }
                is Resource.Failure -> {

                }
            }
        }catch (ex: Exception){
            Log.e("ADMINMENU", ex.message.toString())
        }

    }
}