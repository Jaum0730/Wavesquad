package com.teste.chatapp.compose.data.di

import com.teste.chatapp.compose.data.auth.FirebaseAuthUser
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FirebaseAuthModule {

    @Singleton
    @Provides
    fun provideFirebaseAuthReference(): FirebaseAuth = Firebase.auth

    @Singleton
    @Provides
    fun provideFirebaseAuthUser(auth: FirebaseAuth): FirebaseAuthUser = FirebaseAuthUser(auth)
}