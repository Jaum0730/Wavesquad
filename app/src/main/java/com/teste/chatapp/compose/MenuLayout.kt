package com.teste.chatapp.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Device
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teste.chatapp.R
import com.teste.chatapp.compose.ui.theme.ChatAppTheme

@Composable
fun InitialLayoutScreen(onContinueClick: () -> Unit) {
    val windowInfo = rememberWindowInfo()
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

    Surface(
        modifier = Modifier
            .fillMaxSize(),
            color = com.teste.chatapp.compose.ui.theme.LightDark80
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            if(windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact){
                // box para os diferentes textos ficarem alinhados
                Box(
                    contentAlignment = Alignment.BottomStart,
                ) {
                    // 1° texto da box
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = com.teste.chatapp.compose.ui.theme.LightBlue80,
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
                        color = com.teste.chatapp.compose.ui.theme.LightBlue80,
                        fontSize = 35.sp,
                        fontFamily = fontFamily,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(start = 222.dp, bottom = 12.dp)
                            .align(Alignment.BottomEnd)
                            .graphicsLayer(rotationZ = -23f)
                    )
                }
            } else {
                Box(
                    contentAlignment = Alignment.BottomStart,
                ) {
                    // 1° texto da box
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = com.teste.chatapp.compose.ui.theme.LightBlue80,
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
                        color = com.teste.chatapp.compose.ui.theme.LightBlue80,
                        fontSize = 35.sp,
                        fontFamily = fontFamily,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(start = 175.dp, bottom = 10.dp)
                            .align(Alignment.BottomEnd)
                            .graphicsLayer(rotationZ = -23f)
                    )
                }
            }
            // botão Login
            Button(
                onClick = {
                    onContinueClick()
                },
                colors = ButtonDefaults.buttonColors(
                    com.teste.chatapp.compose.ui.theme.Orange80
                ),
                modifier = Modifier
                    .size(350.dp, 30.dp)
                    .padding(0.dp, 0.dp, 0.dp, 0.dp)
            ) {
                Text(
                    text = "Login",
                    color = Color.White,
                    fontFamily = fontFamily,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // Box com outro texto duplo
            // fiz em box para eu poder delimitar o padding de cima, já que o tipo "Text" não tem o modificador padding
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


@Composable
@Preview(showSystemUi = true)
fun InitialLayoutScreenPreview() {
    ChatAppTheme {
        InitialLayoutScreen(onContinueClick = {})
    }
}
