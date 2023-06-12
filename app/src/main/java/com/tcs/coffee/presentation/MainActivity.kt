package com.tcs.coffee.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.tcs.coffee.presentation.landing.LandingScreen
import com.tcs.coffee.presentation.theme.NEOMcoffeeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NEOMcoffeeTheme {
                LandingScreen()
            }
        }
    }
}