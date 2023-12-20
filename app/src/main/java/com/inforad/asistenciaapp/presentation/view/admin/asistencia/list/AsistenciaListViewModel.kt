package com.inforad.asistenciaapp.presentation.view.admin.asistencia.list

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inforad.asistenciaapp.domain.model.EstadoReunion
import com.inforad.asistenciaapp.domain.model.Reunion
import com.inforad.asistenciaapp.domain.response.AsistenciaResponse
import com.inforad.asistenciaapp.domain.useCase.asistencias.AsistenciaUseCase
import com.inforad.asistenciaapp.domain.useCase.reuniones.ReunionesUseCase
import com.inforad.asistenciaapp.domain.util.Resource
import androidx.compose.runtime.State
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AsistenciaListViewModel @Inject constructor(
    private val asistenciaUseCase: AsistenciaUseCase,
    private val reunionesUseCase: ReunionesUseCase,
    private val savedStateHandle: SavedStateHandle,
    @ApplicationContext val context: Context
): ViewModel() {
    var asistenciaResponse by mutableStateOf<Resource<List<AsistenciaResponse>>?>(null)
        private set

    var reunionResponse by mutableStateOf<Resource<Reunion>?>(null)
        private set

    val data = savedStateHandle.get<String>("reunion")
    var reunion = Reunion.fromJson(data!!)

    init {
        getAsistencias()
    }

    fun getAsistencias() = viewModelScope.launch {
        asistenciaResponse = Resource.Loading
        asistenciaUseCase.getAsistencia(reunion.id.toString()).collect() {data ->
            asistenciaResponse = data
        }
    }

    fun cerrarReunion() = viewModelScope.launch {
        val estadoReunion = EstadoReunion("FIN")
        reunionResponse = Resource.Loading
        val result = reunionesUseCase.cerrarReunion(reunion.id ?: "", estadoReunion)
        reunionResponse = result
    }
}