package com.inforad.asistenciaapp.presentation.navigation.graph.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.inforad.asistenciaapp.presentation.navigation.Graph
import com.inforad.asistenciaapp.presentation.navigation.screen.auth.AuthScreen
import com.inforad.asistenciaapp.presentation.view.auth.login.LoginView
import com.inforad.asistenciaapp.presentation.view.auth.register.RegisterView

fun NavGraphBuilder.AuthNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreen.Login.route
    ) {
        composable(route = AuthScreen.Login.route) {
            LoginView(navController)
        }
        composable(route = AuthScreen.Register.route) {
            RegisterView(navController)
        }
    }
}