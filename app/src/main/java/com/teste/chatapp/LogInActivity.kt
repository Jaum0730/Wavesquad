package com.teste.chatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class LogInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        val txtLoginEmail: EditText = findViewById<EditText>(R.id.txtLoginEmail)
        val txtLoginPassword: EditText = findViewById<EditText>(R.id.txtLoginPassword)
    }
}