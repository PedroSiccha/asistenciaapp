package com.inforad.asistenciaapp.domain.response

import com.google.gson.Gson
import com.inforad.asistenciaapp.domain.model.User

data class AsistenciaResponse(
    val id: String,
    val estado: String,
    val hora: String,
    val user: User? = null,
) {
    fun toJson(): String = Gson().toJson(this)
    companion object {
        fun fromJson(data: String): AsistenciaResponse = Gson().fromJson(data, AsistenciaResponse::class.java)
    }
}
