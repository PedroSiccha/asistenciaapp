package com.inforad.asistenciaapp.presentation.view.admin.asistencia.escanear

data class AsistenciaCreateState (
    var estado: String = "",
    var hora: String = "",
    val dni: String = "",
    var reunion_id: String = ""
)