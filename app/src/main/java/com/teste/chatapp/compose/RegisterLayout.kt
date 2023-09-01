package com.teste.chatapp.compose

import android.view.View
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teste.chatapp.R
import com.teste.chatapp.compose.components.GoogleButton
import com.teste.chatapp.compose.ui.theme.*

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

//variavel de autenticacao
private lateinit var dbAuth: FirebaseAuth
//variavel  de banco de dados
private val db = Firebase.firestore

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterLayoutScreen(onSignUpClick:() -> Unit){

    //olhar utilidade
    dbAuth = FirebaseAuth.getInstance()

    var user by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    val userMap = hashMapOf(
        "name" to user,
        "email" to email,
        "password" to password,
    )

    val context = LocalContext.current
    val newUserDocument = db.collection("users").document(dbAuth.currentUser!!.uid)
    newUserDocument.set(userMap)
        .addOnSuccessListener {
            Toast.makeText(
                context, "Sucesso! Você será redirecionado!",
                Toast.LENGTH_SHORT
            ).show()

            SignUpCreate(email, password)
        }
        .addOnFailureListener {
            Toast.makeText(context, "Erro ao salvar no Firestore", Toast.LENGTH_SHORT).show()

        }

    val fontFamily = FontFamily(
        Font(R.font.outfit_black, FontWeight.Black),
        Font(R.font.outfit_bold, FontWeight.Bold),
        Font(R.font.outfit_extrabold, FontWeight.ExtraBold),
        Font(R.font.outfit_extralight, FontWeight.ExtraLight),
        Font(R.font.outfit_light, FontWeight.Light),
        Font(R.font.outfit_medium, FontWeight.Medium),
        Font(R.font.outfit_regular, FontWeight.Normal),
        Font(R.font.outfit_semibold, FontWeight.SemiBold),
        Font(R.font.outfit_thin, FontWeight.Thin)

    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LightDark80)
    ) {
       Column(
           modifier = Modifier
               .fillMaxSize(),
           horizontalAlignment = Alignment.CenterHorizontally,
           verticalArrangement = Arrangement.Center
       ) {
           // box para os diferentes textos ficarem alinhados
           Box(
               contentAlignment = Alignment.BottomStart,
           ) {
               // 1° texto da box
               Text(
                   text = buildAnnotatedString {
                       withStyle(
                           style = SpanStyle(
                               color = LightBlue80,
                           )
                       ) {
                           append("W")
                       }
                       append("AVE")
                   },
                   color = Color.White,
                   fontSize = 60.sp,
                   fontFamily = fontFamily,
                   fontWeight = FontWeight.Bold
               )

               // 2° texto da box
               Text(
                   text = "x",
                   color = LightBlue80,
                   fontSize = 35.sp,
                   fontFamily = fontFamily,
                   fontWeight = FontWeight.Bold,
                   modifier = Modifier
                       .padding(start = 175.dp, bottom = 10.dp)
                       .align(Alignment.BottomEnd)
                       .graphicsLayer(rotationZ = -23f)
               )
           }

           TextField(
               value = user,
               onValueChange = { user = it},
               colors = TextFieldDefaults.outlinedTextFieldColors(containerColor = White100),
               label = { Text("Usuário") },
               maxLines = 1,
               modifier = Modifier
                   .width(315.dp)
                   .padding(0.dp, 0.dp, 0.dp, 0.dp)
                   .border(
                       width = 1.dp,
                       color = LightBlue80,
                       shape = RoundedCornerShape(7.dp)
                   ),
               shape = RoundedCornerShape(7.dp),
           )

           TextField(
               value = email,
               onValueChange = { email = it},
               colors = TextFieldDefaults.outlinedTextFieldColors(containerColor = White100),
               label = { Text("Email") },
               maxLines = 1,
               modifier = Modifier
                   .width(315.dp)
                   .padding(0.dp, 12.dp, 0.dp, 0.dp)
                   .border(
                       width = 1.dp,
                       color = LightBlue80,
                       shape = RoundedCornerShape(7.dp)
                   ),
               shape = RoundedCornerShape(7.dp),
           )

           TextField(
               value = password,
               onValueChange = { password = it},
               colors = TextFieldDefaults.outlinedTextFieldColors(containerColor = White100),
               label = { Text("Senha") },
               maxLines = 1,
               modifier = Modifier
                   .width(315.dp)
                   .padding(0.dp, 12.dp, 0.dp, 0.dp)
                   .border(
                       width = 1.dp,
                       color = LightBlue80,
                       shape = RoundedCornerShape(7.dp)
                   ),
               shape = RoundedCornerShape(7.dp),
           )

           Box(
               modifier = Modifier
                   .padding(37.dp, 5.dp)
           ){
               Text(
                   text = buildAnnotatedString {
                       withStyle(
                           style = SpanStyle(
                               color = Color.White
                           )
                       ) {
                           append("Ao criar uma conta você concorda com nossos ")
                       }
                       append("Termos de Serviço")
                       withStyle(
                           style = SpanStyle(
                               color = Color.White
                           )
                       ) {
                           append(" e ")
                       }
                       append("Política de Privacidade")
                   },
                   color = LightBlue80,
                   fontFamily = fontFamily,
                   fontSize = 12.sp,
                   fontWeight = FontWeight.Normal,
                   modifier = Modifier
                       .clickable {  }
               )
           }

           Box(
               modifier = Modifier
                   .padding(22.dp)
           ){
               Button(
                   onClick = {
                       onSignUpClick()
                   },
                   colors = ButtonDefaults.buttonColors(Orange80),
                   modifier = Modifier
                       .size(315.dp, 35.dp)
                       .padding(0.dp, 0.dp, 0.dp, 0.dp)
               ) {
                   Text(
                       text = "Cadastrar",
                       color = Color.White,
                       fontFamily = fontFamily,
                       fontSize = 14.sp,
                       fontWeight = FontWeight.Bold
                   )
               }
           }

           Box(
               modifier = Modifier
                   .width(315.dp)
                   .padding(0.dp, 0.dp, 0.dp, 0.dp)
           ){
               GoogleButton()
           }

           Box(
               modifier = Modifier
                   .padding(0.dp, 20.dp, 0.dp, 0.dp)
           ){
               Text(
                   text = buildAnnotatedString {
                       withStyle(
                           style = SpanStyle(
                               color = Color.White
                           )
                       ) {
                           append("Não tem uma conta? ")
                       }
                       append("Criar conta")
                   },
                   color = LightBlue80,
                   fontFamily = fontFamily,
                   fontSize = 12.sp,
                   fontWeight = FontWeight.Medium,
                   modifier = Modifier
                       .clickable {  }
               )
           }

       }
    }
}


@Preview(showSystemUi = true)
@Composable
fun RegisterLayoutScreenPreview(){
    ChatAppTheme {
        RegisterLayoutScreen(onSignUpClick = {})
    }
}

fun SignUpCreate(context: , email: String, senha: String) {
    
    if (senha.length < 7) {
        Toast.makeText(context, "senha precisa ter no minimo 8 caracteres", Toast.LENGTH_LONG)
            .show()
    }else {
        dbAuth.createUserWithEmailAndPassword(email, senha)
            .addOnCompleteListener(context) { task ->
                if (task.isSuccessful) {

                    Toast.makeText(context, "Conta criada com sucesso", Toast.LENGTH_SHORT).show()

                } else {

                    Toast.makeText(
                        context,
                        "Não foi possível criar a conta. Por favor, tente novamente",
                        Toast.LENGTH_LONG,
                    ).show()
                }
            }
    }
}