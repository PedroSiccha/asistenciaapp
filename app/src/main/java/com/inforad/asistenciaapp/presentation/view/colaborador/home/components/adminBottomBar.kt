package com.inforad.asistenciaapp.presentation.view.colaborador.home.components

import androidx.compose.material.BottomNavigation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.inforad.asistenciaapp.presentation.navigation.screen.coll.CollScreen

@Composable
fun CollBottomBar(navController: NavHostController) {
    val screens = listOf(
        CollScreen.MenuColl,
        CollScreen.ReunionesList,
        CollScreen.ReportesList,
        CollScreen.Profile
    )

    val navBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackEntry?.destination
    val bottomBarDestination = screens.any {
        it.route == currentDestination?.route
    }
    if (bottomBarDestination) {
        BottomNavigation() {
            screens.forEach { screen->
                CollBottomBarItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}