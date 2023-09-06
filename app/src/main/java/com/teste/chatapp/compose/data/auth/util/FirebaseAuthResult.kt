package com.teste.chatapp.compose.data.auth.util

sealed class FirebaseAuthResult<out R> {
    data class Success<out T>(val data: T) : FirebaseAuthResult<T>()
    data class Error(val exception: Throwable) : FirebaseAuthResult<Nothing>()
    object Loading : FirebaseAuthResult<Nothing>()
}