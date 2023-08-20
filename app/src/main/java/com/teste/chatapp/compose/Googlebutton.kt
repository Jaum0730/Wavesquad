package com.teste.chatapp.compose


import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.teste.chatapp.R
import com.teste.chatapp.compose.ui.theme.ChatAppTheme

@ExperimentalMaterial3Api
@Composable
fun Googlebutton(){

    val textwaiting:String = "Continuar com o Google"
    val textloading:String = "Carregando..."
    var clicked by remember { mutableStateOf(false) }

    Surface(
        onClick = {clicked = !clicked},
        shape = RoundedCornerShape(6.dp),
        border = BorderStroke(width = 1.dp, color = Color.White ),
        color = MaterialTheme.colorScheme.surface
    ){
        Row (
            modifier = Modifier
                .padding(
                    start = 14.dp,
                    end = 16.dp,
                    top = 10.dp,
                    bottom = 10.dp
            )
                //trabalha as animações
                .animateContentSize(

                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing


                    )

                )
            ,

            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,

        )

        {
            Icon(painter = painterResource(R.drawable.ic_google_logo), contentDescription = "Google icon",
                tint = Color.Unspecified)
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = if(clicked) textloading else textwaiting)
            if(clicked){
                Spacer(modifier = Modifier.width(10.dp))
                CircularProgressIndicator(
                    modifier = Modifier
                        .width(10.dp)
                        .height(10.dp),
                    strokeWidth = 2.dp,
                    color = MaterialTheme.colorScheme.primary



            )
        }




        }

    }



}


@ExperimentalMaterial3Api
@Composable
@Preview
private fun GooglebuttonPreview(){
    ChatAppTheme {
        Googlebutton()
    }
}