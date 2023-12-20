package com.inforad.asistenciaapp.presentation.view.admin.reporte.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inforad.asistenciaapp.domain.model.Reunion
import com.inforad.asistenciaapp.domain.response.PromedioAsistenciaResponse
import com.inforad.asistenciaapp.domain.useCase.reporte.ReporteUseCase
import com.inforad.asistenciaapp.domain.useCase.reuniones.ReunionesUseCase
import com.inforad.asistenciaapp.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdminReporteViewModel @Inject constructor(
    private val reporteUseCase: ReporteUseCase,
    private val reunionesUseCase: ReunionesUseCase,
): ViewModel() {

    var state by mutableStateOf(AdminReporteState())

    var promedioAsistenciaResource by mutableStateOf<Resource<PromedioAsistenciaResponse>?>(null)
        private set

    var reunionResponse by mutableStateOf<Resource<List<Reunion>>?>(null)
        private set

    init {
        getPromedioAsistencia()
        getReuniones()
    }

    fun getPromedioAsistencia() = viewModelScope.launch {
        promedioAsistenciaResource = Resource.Loading
        val result = reporteUseCase.promedioAsistencia()
        promedioAsistenciaResource = result
    }

    fun getReuniones() = viewModelScope.launch {
        reunionResponse = Resource.Loading
        reunionesUseCase.getAllReuniones().collect() {data ->
            reunionResponse = data
        }
    }
}