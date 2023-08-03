package com.teste.chatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLogin: Button = findViewById(R.id.btnLogin)
        val btnSignUp: Button = findViewById(R.id.btnSingUp)

        btnLogin.setOnClickListener()
        {
            startActivity(Intent(this, LogInActivity::class.java))
        }

        btnSignUp.setOnClickListener()
        {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }
}

