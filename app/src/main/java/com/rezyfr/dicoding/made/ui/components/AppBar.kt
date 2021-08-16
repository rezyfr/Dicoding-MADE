package com.rezyfr.dicoding.made.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.rezyfr.dicoding.made.ui.theme.Green500
import com.rezyfr.dicoding.made.ui.theme.logoStyle

@Composable
fun HomeAppBar() {
    TopAppBar(
        title = {
            Text(
                modifier = Modifier
                    .fillMaxSize().padding(top = 4.dp),
                text = buildAnnotatedString {
                    withStyle(
                        logoStyle(color = Color.White)
                    ) {
                        append("Movie")
                    }
                    withStyle(
                        logoStyle(color = Green500)
                    ) {
                        append("DB")
                    }
                },
                textAlign = TextAlign.Center
            )
        },
        elevation = 0.dp, backgroundColor = Color.Transparent,
//        actions = {
//        IconButton(onClick = { }) {
//            Icon(Icons.Filled.Search, contentDescription = "Search Button")
//        }
//    },
    )
}