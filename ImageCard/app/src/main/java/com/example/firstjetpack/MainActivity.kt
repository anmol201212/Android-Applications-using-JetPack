package com.example.firstjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstjetpack.ui.theme.FirstJetPackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .background(Color.Green)
                    .fillMaxSize(0.5f)
//                    .padding(16.dp)
                    .border(5.dp, Color.Black)
            ) {
//                Text("Hey")
                Text("Hey", modifier= Modifier
                    .padding(10.dp)
                    .clickable {  })
                Spacer(modifier = Modifier.height(50.dp))
                Text("Buddy", modifier = Modifier.padding(10.dp))
            }
        }
    }
}
