package com.inforad.asistenciaapp.domain.model

import com.google.gson.Gson

data class ReunionResponse(
    val reunion: Reunion? = null
) {
    fun toJson(): String = Gson().toJson(this)
    companion object {
        fun fromJson(data: String): ReunionResponse = Gson().fromJson(data, ReunionResponse::class.java)
    }
}
