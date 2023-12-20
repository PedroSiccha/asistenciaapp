package com.inforad.asistenciaapp.presentation.view.colaborador.reporte.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inforad.asistenciaapp.domain.response.PromedioAsistenciaResponse
import com.inforad.asistenciaapp.domain.useCase.reporte.ReporteUseCase
import com.inforad.asistenciaapp.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CollReporteViewModel @Inject constructor(private val reporteUseCase: ReporteUseCase): ViewModel() {

    var promedioAsistenciaResource by mutableStateOf<Resource<PromedioAsistenciaResponse>?>(null)
        private set

    init {
        getPromedioAsistencia()
    }

    fun getPromedioAsistencia() = viewModelScope.launch {
        promedioAsistenciaResource = Resource.Loading
        val result = reporteUseCase.promedioAsistenciaUsuario("1")
        promedioAsistenciaResource = result
    }

}