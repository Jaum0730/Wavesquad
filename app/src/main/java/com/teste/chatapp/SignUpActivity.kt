package com.teste.chatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        var etName: EditText = findViewById(R.id.etName)
        var etAddress: EditText = findViewById(R.id.etAddress)
        var etEmail: EditText = findViewById(R.id.etEmail)
        var etPassword: EditText = findViewById(R.id.etPassword)
        var btnSignUp: Button = findViewById(R.id.btnConfirmSignUp)

        btnSignUp.setOnClickListener{
            val strName = etName.text.toString().trim()
            val strAddress = etAddress.text.toString().trim()
            val strEmail = etEmail.text.toString().trim()
            val strPassword = etPassword.text.toString().trim()

        }
    }
}