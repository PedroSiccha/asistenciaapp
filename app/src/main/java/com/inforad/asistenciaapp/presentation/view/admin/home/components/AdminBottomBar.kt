package com.inforad.asistenciaapp.presentation.view.admin.home.components

import androidx.compose.material.BottomNavigation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.inforad.asistenciaapp.presentation.navigation.screen.admin.AdminScreen

@Composable
fun AdminBottomBar(navController: NavHostController) {
    val screens = listOf(
        AdminScreen.MenuAdmin,
        AdminScreen.ReunionesList,
        AdminScreen.ReportesList,
        AdminScreen.Profile
    )

    val navBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackEntry?.destination
    val bottomBarDestination = screens.any {
        it.route == currentDestination?.route
    }
    if (bottomBarDestination) {
        BottomNavigation() {
            screens.forEach { screen->
                AdminBottomBarItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}