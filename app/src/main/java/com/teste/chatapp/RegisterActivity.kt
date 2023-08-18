 package com.teste.chatapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.compose.setContent

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.teste.chatapp.compose.RegisterLayoutScreenPreview


<<<<<<< HEAD:app/src/main/java/com/teste/chatapp/RegisterActivity.kt
 class RegisterActivity : AppCompatActivity() {

=======
 class SignUpActivity : AppCompatActivity() {
>>>>>>> 7a3e9b8cfecdf94b0baf4f8b1354e9bbc30dfae1:app/src/main/java/com/teste/chatapp/SignUpActivity.kt
    //variavel de autenticacao
    private lateinit var dbAuth: FirebaseAuth
    //variavel  de banco de dados
    private val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            RegisterLayoutScreenPreview()
        }
<<<<<<< HEAD:app/src/main/java/com/teste/chatapp/RegisterActivity.kt

=======
        //olhar utilidade
>>>>>>> 7a3e9b8cfecdf94b0baf4f8b1354e9bbc30dfae1:app/src/main/java/com/teste/chatapp/SignUpActivity.kt
        dbAuth = FirebaseAuth.getInstance()

        var etName: EditText = findViewById(R.id.etName)
        var etAddress: EditText = findViewById(R.id.etAddress)
        var etEmail: EditText = findViewById(R.id.etEmail)
        var etPassword: EditText = findViewById(R.id.etPassword)
        var etPhoneNumber: EditText = findViewById(R.id.etPassword)
        var btnSignUp: Button = findViewById(R.id.btnConfirmSignUp)

        btnSignUp.setOnClickListener {
            // Adicionando ao banco de dados
            val progressBar: ProgressBar = findViewById(R.id.prgBarSignUp)
            progressBar.visibility = View.VISIBLE
            btnSignUp.visibility = View.GONE
            btnSignUp.isEnabled = false

            Thread.sleep(200)

            val strPhoneNumber = etPhoneNumber.text.toString().trim()
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
                "email" to strEmail,
                "password" to strPassword,
                "name" to strName,
                "address" to strAddress,
                "phone number" to strPhoneNumber
            )

            val newUserDocument = db.collection("users").document(dbAuth.currentUser!!.uid)
            newUserDocument.set(userMap)
                .addOnSuccessListener {
                    Toast.makeText(
                        this,
                        "Sucesso! Você será redirecionado!",
                        Toast.LENGTH_SHORT
                    ).show()
                    etName.text.clear()
                    etAddress.text.clear()
                    etEmail.text.clear()
                    etPassword.text.clear()

                    progressBar.visibility = View.GONE
                    btnSignUp.visibility = View.VISIBLE
                    btnSignUp.isEnabled = true

                    SingUpcreate(strEmail, strPassword)
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Erro ao salvar no Firestore", Toast.LENGTH_SHORT).show()

                    progressBar.visibility = View.GONE
                    btnSignUp.visibility = View.VISIBLE
                    btnSignUp.isEnabled = true
                }

        }
    }

    fun SingUpcreate(email: String, senha: String) {

        if (senha.length < 7) {
            Toast.makeText(this, "senha precisa ter no minimo 8 caracteres", Toast.LENGTH_LONG)
                .show()
        }else {
            dbAuth.createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {

                        Toast.makeText(this, "Conta criada com sucesso", Toast.LENGTH_SHORT).show()

                    } else {

                        Toast.makeText(
                            baseContext,
                            "Não foi possível criar a conta. Por favor, tente novamente",
                            Toast.LENGTH_LONG,
                        ).show()
                    }
                }
        }
    }
}