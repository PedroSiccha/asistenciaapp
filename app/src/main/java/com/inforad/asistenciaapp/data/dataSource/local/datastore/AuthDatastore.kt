package com.inforad.asistenciaapp.data.dataSource.local.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.inforad.asistenciaapp.core.Config
import com.inforad.asistenciaapp.domain.model.AuthResponse
import com.inforad.asistenciaapp.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

class AuthDatastore constructor(private val dataStore: DataStore<Preferences>) {
    suspend fun saveUser(authResponse: AuthResponse) {
        val dataStoreKey = stringPreferencesKey(Config.AUTH_KEY)
        dataStore.edit { pref->
            pref[dataStoreKey] = authResponse.toJson()
        }
    }

    suspend fun updateUser(user: User) {
        val dataStoreKey = stringPreferencesKey(Config.AUTH_KEY)
        val authResponse = runBlocking {
            getData().first()
        }
        authResponse.user?.name = user.name
        authResponse.user?.lastname = user.lastname
        authResponse.user?.phone = user.phone
        authResponse.user?.numeroPadron = user.numeroPadron
        authResponse.user?.lote = user.lote
        authResponse.user?.lotesDetalle = user.lotesDetalle
        authResponse.user?.lotesCantidad = user.lotesCantidad
        authResponse.user?.manzana = user.manzana
        authResponse.user?.metros = user.metros
        dataStore.edit { pref->
            pref[dataStoreKey] = authResponse.toJson()
        }
    }

    suspend fun delete() {
        val dataStoreKey = stringPreferencesKey(Config.AUTH_KEY)
        dataStore.edit { pref->
            pref.remove(dataStoreKey)
        }
    }

    fun getData(): Flow<AuthResponse> {
        val dataStoreKey = stringPreferencesKey(Config.AUTH_KEY)
        return dataStore.data.map { pref ->
            if (pref[dataStoreKey] != null) {
                AuthResponse.fromJson(pref[dataStoreKey]!!)
            } else {
                AuthResponse()
            }
        }
    }
}