package com.inforad.asistenciaapp.presentation.view.admin.reunion.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inforad.asistenciaapp.domain.model.Reunion
import com.inforad.asistenciaapp.domain.useCase.reuniones.ReunionesUseCase
import com.inforad.asistenciaapp.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdminReunionListViewModel @Inject constructor(private val reunionesUseCase: ReunionesUseCase): ViewModel() {
    var reunionesResponse by mutableStateOf<Resource<List<Reunion>>?>(null)
        private set

    init {
        getReuniones()
    }

    fun getReuniones() = viewModelScope.launch {
        reunionesResponse = Resource.Loading
        reunionesUseCase.getReunion().collect() {data ->
            reunionesResponse = data
        }
    }
}