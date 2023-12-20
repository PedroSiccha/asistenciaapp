package com.inforad.asistenciaapp.presentation.view.admin.colaborador.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inforad.asistenciaapp.domain.model.User
import com.inforad.asistenciaapp.domain.useCase.users.UsersUseCase
import com.inforad.asistenciaapp.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdminColaboradorListViewModel @Inject constructor(private val usersUseCase: UsersUseCase): ViewModel() {
    var usersResponse by mutableStateOf<Resource<List<User>>?>(null)
        private set

    var deleteUserResponse by mutableStateOf<Resource<Unit>?>(null)
        private set

    var search by mutableStateOf("")
/*
    init {
        getUsers()
    }

 */

    fun getUsers() = viewModelScope.launch {
        usersResponse = Resource.Loading
        usersUseCase.getUser().collect() {data ->
            usersResponse = data
        }
    }

    fun getUsersByName(dato: String) = viewModelScope.launch {
        usersResponse = Resource.Loading
        usersUseCase.findByName(dato).collect() {data ->
            usersResponse = data
        }
    }

    fun onSearchInput(value: String) {
        search = value
    }

    fun deleteUser(id: String) = viewModelScope.launch {
        deleteUserResponse = Resource.Loading
        val result = usersUseCase.deleteUser(id)
        deleteUserResponse = result
    }
}