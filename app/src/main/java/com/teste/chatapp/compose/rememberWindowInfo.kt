package com.teste.chatapp.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// Função composável que retorna informações sobre a janela com base na configuração local.
@Composable
fun rememberWindowInfo(): WindowInfo {
    // Obtém a configuração local da tela.
    val configuration = LocalConfiguration.current

    // Determina o tipo de janela com base na largura da tela.
    val screenWidthInfo = when {
        configuration.screenWidthDp < 600 -> WindowInfo.WindowType.Compact
        configuration.screenWidthDp < 840 -> WindowInfo.WindowType.Medium
        else -> WindowInfo.WindowType.Expanded
    }

    // Determina o tipo de janela com base na altura da tela.
    val screenHeightInfo = when {
        configuration.screenHeightDp < 480 -> WindowInfo.WindowType.Compact
        configuration.screenHeightDp < 900 -> WindowInfo.WindowType.Medium
        else -> WindowInfo.WindowType.Expanded
    }

    // Cria uma instância de WindowInfo com as informações coletadas.
    return WindowInfo(
        screenWidthInfo = screenWidthInfo,
        screenHeightInfo = screenHeightInfo,
        screenWidth = configuration.screenWidthDp.dp,
        screenHeight = configuration.screenHeightDp.dp
    )
}

// Classe de dados que armazena informações sobre a janela.
data class WindowInfo(
    val screenWidthInfo: WindowType,       // Tipo de janela com base na largura.
    val screenHeightInfo: WindowType,      // Tipo de janela com base na altura.
    val screenWidth: Dp,                   // Largura da tela em Dp.
    val screenHeight: Dp                   // Altura da tela em Dp.
) {
    // Classe selada que representa os tipos possíveis de janela.
    sealed class WindowType {
        object Compact : WindowType()       // Janela compacta.
        object Medium : WindowType()        // Janela média.
        object Expanded : WindowType()      // Janela expandida.
    }
}
