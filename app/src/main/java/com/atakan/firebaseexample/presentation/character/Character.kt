package com.atakan.firebaseexample.presentation.character

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.atakan.firebaseexample.domain.model.Character
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun Character(
    character: Character
) {
    val cardColor = if(character.status == "Alive") Color.Green else if (character.status == "Dead") Color.Red else Color.Gray
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .clip(shape = RoundedCornerShape(20.dp))
            .background(color = Color.White)
    ){
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Top
        ) {
            GlideImage(
                model = character.image,
                contentDescription = character.name,
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(1f)
            )
            Box(
                modifier = Modifier
                    .background(color = cardColor)
                    .fillMaxSize()
            )

        }
    }
}