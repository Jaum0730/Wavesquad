package com.teste.chatapp.compose.data.ui.state

sealed interface FirebaseLoginState {
    object Success : FirebaseLoginState
    object Error : FirebaseLoginState
    object Loading : FirebaseLoginState
    object Empty : FirebaseLoginState
}