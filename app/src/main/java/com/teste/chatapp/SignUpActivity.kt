 package com.teste.chatapp

import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase



class SignUpActivity : AppCompatActivity() {
    //variavel de autenticacao
    private lateinit var dbAuth: FirebaseAuth
    //variavel  de banco de dados
    private val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        dbAuth = FirebaseAuth.getInstance()

        var etName: EditText = findViewById(R.id.etName)
        var etAddress: EditText = findViewById(R.id.etAddress)
        var etEmail: EditText = findViewById(R.id.etEmail)
        var etPassword: EditText = findViewById(R.id.etPassword)
        var btnSignUp: Button = findViewById(R.id.btnConfirmSignUp)

        btnSignUp.setOnClickListener{
            // Adicionando ao banco de dados
            val progressBar: ProgressBar = findViewById(R.id.prgBarSignUp)
            progressBar.visibility = View.VISIBLE
            btnSignUp.visibility = View.GONE
            btnSignUp.isEnabled = false

            Thread.sleep(200)

            val strName = etName.text.toString().trim()
            val strAddress = etAddress.text.toString().trim()
            val strEmail = etEmail.text.toString().trim()
            val strPassword = etPassword.text.toString().trim()

            if (strName.isBlank() || strAddress.isBlank() || strEmail.isBlank() || strPassword.isBlank()) {
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()

                etName.text.clear()
                etAddress.text.clear()
                etEmail.text.clear()
                etPassword.text.clear()

                progressBar.visibility = View.GONE
                btnSignUp.visibility = View.VISIBLE
                btnSignUp.isEnabled = true

                return@setOnClickListener
            }

            val userMap = hashMapOf(
                "name" to strName,
                "address" to strAddress,
                "email" to strEmail,
                "password" to strPassword
            )

            val newUserDocument = db.collection("users").document(dbAuth.currentUser!!.uid)
            newUserDocument.set(userMap)
                .addOnSuccessListener {
                    Toast.makeText(
                        this,
                        "Successfully Added! Check the DataBase",
                        Toast.LENGTH_SHORT
                    ).show()
                    etName.text.clear()
                    etAddress.text.clear()
                    etEmail.text.clear()
                    etPassword.text.clear()


                    progressBar.visibility = View.GONE
                    btnSignUp.visibility = View.VISIBLE
                    btnSignUp.isEnabled = true

                    SingUpcreate(strEmail,strPassword)
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Failure to save in DataBase", Toast.LENGTH_SHORT).show()

                    progressBar.visibility = View.GONE
                    btnSignUp.visibility = View.VISIBLE
                    btnSignUp.isEnabled = true
                }
        }
    }

   fun SingUpcreate(email:String, senha:String){

       if(senha.length < 7)
           Toast.makeText(this, "senha precisa ter no minimo 8 caracteres", Toast.LENGTH_SHORT).show()


        dbAuth.createUserWithEmailAndPassword(email, senha)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)

                } else {

                    Toast.makeText(
                        baseContext,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT,
                    ).show()

                }
            }




   }


}