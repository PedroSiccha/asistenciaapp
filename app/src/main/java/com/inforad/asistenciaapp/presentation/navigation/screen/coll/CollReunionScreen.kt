package com.inforad.asistenciaapp.presentation.navigation.screen.coll

import com.inforad.asistenciaapp.domain.model.Reunion

sealed class CollReunionScreen(val route: String) {
    object collReunionView: CollReunionScreen("coll/reunion/view")
}
