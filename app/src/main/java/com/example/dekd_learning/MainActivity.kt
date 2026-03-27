package com.example.dekd_learning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.ui.Modifier
import com.example.dekd_learning.ui.raceapp.RaceTrackerApp
import com.example.dekd_learning.ui.sportapp.SportsApp
import com.example.dekd_learning.ui.theme.DekD_LearningTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DekD_LearningTheme (){
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    RaceTrackerApp()
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun AppPreview(){
//    DekD_LearningTheme (){
//        SportsApp()
//    }
//}

