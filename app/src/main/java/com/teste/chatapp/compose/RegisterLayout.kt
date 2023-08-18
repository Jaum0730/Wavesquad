package com.teste.chatapp.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teste.chatapp.R
import com.teste.chatapp.compose.ui.theme.ChatAppTheme
import com.teste.chatapp.compose.ui.theme.LightBlue80
import com.teste.chatapp.compose.ui.theme.Orange80
import com.teste.chatapp.compose.ui.theme.White100

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterLayoutScreen(onSignUpClick:() -> Unit){
    var user by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

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
            .background(com.teste.chatapp.compose.ui.theme.LightDark80)
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

           OutlinedTextField(
               value = user,
               onValueChange = { email = it },
               label = { Text("Usuário") },
               colors = TextFieldDefaults.outlinedTextFieldColors(containerColor = White100),
               modifier = Modifier
                   .padding(5.dp)
           )

           OutlinedTextField(
               value = email,
               onValueChange = { email = it },
               label = { Text("Email") },
               colors = TextFieldDefaults.outlinedTextFieldColors(containerColor = White100),
               modifier = Modifier
                   .padding(5.dp)
           )

           OutlinedTextField(
               value = password,
               onValueChange = { password = it },
               label = { Text("Senha") },
               visualTransformation = PasswordVisualTransformation(),
               colors = TextFieldDefaults.outlinedTextFieldColors(containerColor = White100),
               keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
               modifier = Modifier
                   .padding(5.dp)
           )

           Box(
               modifier = Modifier
                   .padding(30.dp, 5.dp)
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
                   color = com.teste.chatapp.compose.ui.theme.LightBlue80,
                   fontFamily = fontFamily,
                   fontSize = 12.sp,
                   fontWeight = FontWeight.Normal,
                   modifier = Modifier
                       .clickable {  }
               )
           }

           Box(
               modifier = Modifier
                   .padding(8.dp)
           ){
               Button(
                   onClick = { onSignUpClick() },
                   colors = ButtonDefaults.buttonColors(
                       Orange80
                   ),
                   modifier = Modifier
                       .size(350.dp, 30.dp)
                       .padding(0.dp, 0.dp, 0.dp, 0.dp)
               ) {
                   Text(
                       text = "Cadastrar",
                       color = Color.White,
                       fontFamily = fontFamily,
                       fontSize = 12.sp,
                       fontWeight = FontWeight.Bold
                   )
               }
           }

           Box(
               modifier = Modifier
                   .padding(8.dp)
           ){
               Button(
                   onClick = { /*TODO*/ },
                   colors = ButtonDefaults.buttonColors(
                       Color.White
                   ),
                   modifier = Modifier
                       .size(350.dp, 30.dp)
                       .padding(0.dp, 0.dp, 0.dp, 0.dp)
               )

               {
                   Text(
                       text = "Continuar com Google",
                       color = Color.Black,
                       fontFamily = fontFamily,
                       fontSize = 12.sp,
                       fontWeight = FontWeight.Bold
                   )
               }
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
                   color = com.teste.chatapp.compose.ui.theme.LightBlue80,
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


@Preview
@Composable
fun RegisterLayoutScreenPreview(){
    ChatAppTheme {
        RegisterLayoutScreen(onSignUpClick = {})
    }
}