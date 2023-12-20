package com.inforad.asistenciaapp.presentation.view.auth.register

data class RegisterState(
    val name: String = "",
    val lastname: String = "",
    val dni: String = "",
    val email: String = "",
    val telefono: String = "",
    val numeroPadron: Int = 0,
    val lote: Int = 0,
    val manzana: String = "",
    val metros: String = "",
    val lotesCantidad: String = "",
    val lotesDetalle: String = "",
    val imagen: String = ""
)
