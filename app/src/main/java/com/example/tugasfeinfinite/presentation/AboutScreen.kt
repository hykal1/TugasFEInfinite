package com.example.tugasfeinfinite.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasfeinfinite.R
import com.example.tugasfeinfinite.ui.theme.TugasFEInfiniteTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(
    modifier: Modifier = Modifier
) {
    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text("About Me") },
            )
        }
    ){innerPadding ->
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = innerPadding)
        ){
            HykalImage()

        }
    }

}

@Composable
fun HykalImage() {
    Image(
        painter = painterResource(id = R.drawable.me),
        contentDescription = "hykal",
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun Information() {
    Text(text = "Muhammad Hykal nurhakim")
    Text(text = "hykalhakim312@gmail.com")
    Text(text = "UPN Veteran Jakarta")
    Text(text = "Informatika")
}

@Preview(showBackground = true)
@Composable
fun AboutContentPreview() {
    TugasFEInfiniteTheme {
        AboutScreen()
    }
}