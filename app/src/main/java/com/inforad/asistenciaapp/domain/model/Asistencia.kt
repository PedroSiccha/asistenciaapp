package com.inforad.asistenciaapp.domain.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Asistencia (
    @SerializedName("id")
    val id: String? = null,

    @SerializedName("estado")
    val estado: String? = null,

    @SerializedName("hora")
    val hora: String? = null,

    @SerializedName("dni")
    val dni: String? = null,

    @SerializedName("reunionId")
    val reunion_id: String? = null,
): Serializable {
    fun toJson(): String = Gson().toJson(Asistencia(id, estado, hora, dni, reunion_id))

    companion object {
        fun fromJson(data: String): Rol = Gson().fromJson(data, Rol::class.java)
    }
}