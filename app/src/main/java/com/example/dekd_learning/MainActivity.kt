package com.example.dekd_learning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dekd_learning.ui.WoofApp
import com.example.dekd_learning.ui.theme.DekD_LearningTheme
import com.example.dekd_learning.ui.unscramble_game.UnscrambleGameScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DekD_LearningTheme (){
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    UnscrambleGameScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview(){
    DekD_LearningTheme (){
        WoofApp()
    }
}

