package com.inforad.asistenciaapp.presentation.view.admin.reunion.update

import android.content.Context
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inforad.asistenciaapp.domain.model.Reunion
import com.inforad.asistenciaapp.domain.useCase.reuniones.ReunionesUseCase
import com.inforad.asistenciaapp.domain.util.Resource
import com.inforad.asistenciaapp.presentation.view.admin.reunion.create.mapper.toReunion
import com.inforad.asistenciaapp.presentation.view.admin.reunion.update.mapper.toReunion
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdminReunionUpdateViewModel @Inject constructor(
    private val reunionesUseCase: ReunionesUseCase,
    @ApplicationContext val context: Context
    ): ViewModel() {
    var state by mutableStateOf(AdminReunionesUpdateState())
        private set

    var updateReunionesResponse by mutableStateOf<Resource<Reunion >?>(null)
        private set

    fun updateReunion() = viewModelScope.launch {
        updateReunionesResponse = Resource.Loading
        val result = reunionesUseCase.updateReunion(state.toReunion())
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