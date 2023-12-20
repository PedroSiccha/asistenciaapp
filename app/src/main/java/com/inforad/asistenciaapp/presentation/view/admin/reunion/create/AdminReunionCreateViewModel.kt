package com.inforad.asistenciaapp.presentation.view.admin.reunion.create

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inforad.asistenciaapp.domain.model.Reunion
import com.inforad.asistenciaapp.domain.useCase.reuniones.CreateReunionesUseCase
import com.inforad.asistenciaapp.domain.useCase.reuniones.ReunionesUseCase
import com.inforad.asistenciaapp.domain.util.Resource
import com.inforad.asistenciaapp.presentation.view.admin.reunion.create.mapper.toReunion
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdminReunionCreateViewModel @Inject constructor(
    private val reunionesUseCase: ReunionesUseCase,
    @ApplicationContext val context: Context
    ): ViewModel() {
    var state by mutableStateOf(AdminReunionesCreateState())
        private set

    fun msmSuccess(){
        Toast.makeText(context, "La reunión se registró correctamente", Toast.LENGTH_LONG).show()
    }

    var createReunionesResponse by mutableStateOf<Resource<Reunion >?>(null)
        private set

    fun createReunion() = viewModelScope.launch {
        state.estado = "PENDIENTE"
        createReunionesResponse = Resource.Loading
        val result = reunionesUseCase.createReunion(state.toReunion())
        createReunionesResponse = result
    }

    fun onAsuntoInput(input: String) {
        state = state.copy(asunto = input)
    }

    fun onDetalleInput(input: String) {
        state = state.copy(detalle = input)
    }

    fun onFechaInput(input: String) {
        state = state.copy(fecha = input)
    }
}