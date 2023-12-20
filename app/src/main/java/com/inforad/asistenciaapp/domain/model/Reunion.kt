package com.inforad.asistenciaapp.domain.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

data class Reunion(
    @SerializedName("id")
    val id: String? = null,

    @SerializedName("asunto")
    val asunto: String,

    @SerializedName("detalle")
    val detalle: String? = null,

    @SerializedName("fecha")
    val fecha: String,

    @SerializedName("estado")
    val estado: String,

): Serializable {
    fun toJson(): String = Gson().toJson(Reunion(
        id,
        asunto,
        detalle,
        if (!fecha.isNullOrBlank()) "" else "" ,
        estado))

    companion object {
        fun fromJson(data: String): Reunion = Gson().fromJson(data, Reunion::class.java)
    }
}


