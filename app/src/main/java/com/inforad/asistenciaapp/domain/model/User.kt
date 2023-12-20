package com.inforad.asistenciaapp.domain.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

data class User(
    @SerializedName("id")
    val id: String? = null,

    @SerializedName("name")
    var name: String,

    @SerializedName("lastname")
    var lastname: String,

    @SerializedName("email")
    val email: String? = null,

    @SerializedName("phone")
    var phone: String,

    @SerializedName("image")
    val imagen: String? = null,

    @SerializedName("password")
    val password: String? = null,

    @SerializedName("notification_token")
    val notificationToken: String? = null,

    @SerializedName("dni")
    val dni: String? = null,

    @SerializedName("numero_padron")
    var numeroPadron: Int,

    @SerializedName("manzana")
    var manzana: String,

    @SerializedName("lote")
    var lote: Int,

    @SerializedName("metros")
    var metros: String,

    @SerializedName("lotes_detalle")
    var lotesDetalle: String,

    @SerializedName("lotes_cantidad")
    var lotesCantidad: String,

    @SerializedName("roles")
    val roles: List<Rol>? = null

): Serializable {
    fun toJson(): String = Gson().toJson(User(
        id,
        name,
        lastname,
        email,
        phone,
        if (!imagen.isNullOrBlank()) URLEncoder.encode(imagen, StandardCharsets.UTF_8.toString()) else "",
        password,
        notificationToken,
        dni,
        numeroPadron,
        manzana,
        lote,
        metros,
        lotesDetalle,
        lotesCantidad,
        roles?.map { rol -> Rol.fromJson(rol.toJson()) }

    ))
    companion object {
        fun fromJson(data: String): User = Gson().fromJson(data, User::class.java)
    }
}
