package com.teste.chatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.teste.chatapp.compose.ui.theme.ChatAppTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatAppTheme {
                PreviewMenuScreen()

                }
            }
        }
    }



