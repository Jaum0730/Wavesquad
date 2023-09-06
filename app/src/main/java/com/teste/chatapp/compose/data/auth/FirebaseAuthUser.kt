package com.teste.chatapp.compose.data.auth


import com.teste.chatapp.compose.data.auth.util.FirebaseAuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow

import javax.inject.Inject

class FirebaseAuthUser @Inject constructor(
    private val auth: FirebaseAuth
) {
    // Esta função retorna um Flow de FirebaseUser (usuário atualmente autenticado).
    fun getUser(): Flow<FirebaseUser?> = flow {
        emit(auth.currentUser)
    }

    // Esta função é usada para registrar um novo usuário com um email e senha.
    suspend fun signUpAuthUser(
        email: String,
        password: String
    ) : Flow<FirebaseAuthResult<String>> = callbackFlow {
        trySend(FirebaseAuthResult.Loading)
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                trySend(FirebaseAuthResult.Success("User Signed"))
            } else {
                trySend(FirebaseAuthResult.Error(Throwable(task.exception?.message ?: "Some Error Occurred")))
            }
        }
        awaitClose { close() }
    }

    // Esta função é usada para fazer login de um usuário com um email e senha.
    suspend fun signInAuthUser(
        email: String,
        password: String
    ) : Flow<FirebaseAuthResult<String>> = callbackFlow {
        trySend(FirebaseAuthResult.Loading)
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                trySend(FirebaseAuthResult.Success("User Connected"))
            } else {
                trySend(FirebaseAuthResult.Error(Throwable(task.exception?.message ?: "Some Error Occurred")))
            }
        }
        awaitClose { close() }
    }

    // Esta função é usada para desconectar um usuário autenticado.
    suspend fun signOutAuthUser() : Flow<FirebaseAuthResult<String>> = callbackFlow {
        trySend(FirebaseAuthResult.Loading)
        try {
            auth.signOut()
            trySend(FirebaseAuthResult.Success("User Disconnected"))
        } catch (e: Exception) {
            trySend(FirebaseAuthResult.Error(Throwable(e.message)))
        }
        awaitClose { close() }
    }
}
