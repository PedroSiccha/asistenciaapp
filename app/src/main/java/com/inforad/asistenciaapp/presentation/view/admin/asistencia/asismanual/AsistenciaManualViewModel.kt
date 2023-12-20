package com.inforad.asistenciaapp.presentation.view.admin.asistencia.asismanual

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inforad.asistenciaapp.domain.model.Asistencia
import com.inforad.asistenciaapp.domain.model.Reunion
import com.inforad.asistenciaapp.domain.useCase.asistencias.AsistenciaUseCase
import com.inforad.asistenciaapp.domain.util.Resource
import com.inforad.asistenciaapp.presentation.view.admin.asistencia.escanear.AsistenciaCreateState
import com.inforad.asistenciaapp.presentation.view.admin.asistencia.escanear.mapper.toAsistencia
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class AsistenciaManualViewModel @Inject constructor(
    private val asistenciaUseCase: AsistenciaUseCase,
    private val savedStateHandle: SavedStateHandle,
    @ApplicationContext val context: Context
): ViewModel() {
    val data = savedStateHandle.get<String>("reunion")
    var reunion = Reunion.fromJson(data!!)

    var state by mutableStateOf(AsistenciaCreateState())
        private set

    var createAsistenciaResponse by mutableStateOf<Resource<Asistencia>?>(null)
        private set

    fun createAsistencia() = viewModelScope.launch {
        state.hora = obtenerHoraActual()
        state.reunion_id = reunion.id.toString()
        state.estado = "ASISTIO"
        createAsistenciaResponse = Resource.Loading
        val result = asistenciaUseCase.createUseCase(state.toAsistencia())
        createAsistenciaResponse = result
    }

    fun obtenerHoraActual(): String {
        val formatoHora = SimpleDateFormat("HH:mm", Locale.getDefault())
        val horaActual = Calendar.getInstance().time
        return formatoHora.format(horaActual)
    }

    fun onDniInput(input: String) {
        state = state.copy(dni = input)
    }
}