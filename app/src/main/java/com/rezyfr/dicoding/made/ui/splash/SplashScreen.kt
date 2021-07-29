package com.rezyfr.dicoding.made.ui.splash

import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.rezyfr.dicoding.made.R

@Composable
fun SplashScreen(
    onTimeFinished: () -> Unit = {}
) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_movie),
            contentDescription = "Splashscreen",
            Modifier.height(100.dp).width(100.dp),
        )
    }
    Handler(Looper.getMainLooper()).postDelayed({
        onTimeFinished()
    }, 1500)
}