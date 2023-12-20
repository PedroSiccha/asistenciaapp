package com.inforad.asistenciaapp.presentation.view.profile.update

data class ProfileUpddateState(
    val name: String = "",
    val lastname: String = "",
    val phone: String = "",
    val numeroPadron: Int = 0,
    val lote: Int = 0,
    val dni: String? = "",
    val manzana: String = "",
    val metros: String = "",
    val lotesCantidad: String = "",
    val lotesDetalle: String = "",
    val email: String = "",
    val imagen: String = ""
)
