package com.teste.chatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase


private lateinit var mAuth: FirebaseAuth

class LogInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        mAuth = FirebaseAuth.getInstance()
        var txtLoginEmail: EditText = findViewById<EditText>(R.id.txtLoginEmail)
        var txtLoginPassword: EditText = findViewById<EditText>(R.id.txtLoginPassword)
        var btn_login: Button = findViewById(R.id.Login)




        btn_login.setOnClickListener(){
            val email = txtLoginEmail.text.toString()
            val senha = txtLoginPassword.text.toString()

            login(email, senha);


        }




    }

    private fun login(email: String, senha: String){


    }



}

