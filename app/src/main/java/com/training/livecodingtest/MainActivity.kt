package com.training.livecodingtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.training.livecodingtest.ui.navigation.UserNavigation
import com.training.livecodingtest.ui.theme.LiveCodingTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LiveCodingTestTheme {
                UserNavigation()
            }
        }
    }
}