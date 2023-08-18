package com.teste.chatapp

import com.teste.chatapp.compose.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InitialLayoutScreenPreview()

            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "main"){
                composable("main"){
                    InitialLayoutScreen(onContinueClick = {navController.navigate("signIn")})
                }

                composable("signIn"){
                    LoginLayoutScreen(onLoginClick = {navController.navigate("signUp")})
                }

                composable("signUp"){
                    RegisterLayoutScreen(onSignUpClick = {navController.navigate("main")})
                }
            }
        }

    }
}


