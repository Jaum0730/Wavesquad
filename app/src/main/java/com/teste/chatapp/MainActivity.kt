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
            // Intent estava implemendata da maneira errada
            // Tinha que ter importado o pluguin no gradle build.gradle (ChatApp)-> id 'com.android.library' version '8.1.0' apply false
            val Intent = Intent(this, LogInActivity::class.java)
            startActivity(Intent)
        }

        btnSignUp.setOnClickListener()
        {

            val Intent = Intent(this, SignUpActivity::class.java)
            startActivity(Intent)
        }
    }
}

