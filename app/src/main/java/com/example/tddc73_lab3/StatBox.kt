package com.example.tddc73_lab3

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun StatBox(icon:Int, stat:Int=0, color: Color = Color.DarkGray) {

    Box(
        modifier = Modifier
            .background(color = color)
            .width(110.dp)
            .height(35.dp),
        contentAlignment = Alignment.Center,
    ){
        Row (horizontalArrangement = Arrangement.SpaceEvenly){
            Image(painter = painterResource(id = icon),
                contentDescription = "star image",
                modifier = Modifier.size(20.dp))
            Text(text = stat.toString(), color = Color.White
                , modifier = Modifier.padding(start=5.dp))
        }
    }
}