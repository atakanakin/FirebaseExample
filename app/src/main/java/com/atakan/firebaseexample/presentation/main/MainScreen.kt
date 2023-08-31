package com.atakan.firebaseexample.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.atakan.firebaseexample.presentation.sign_in.UserData

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun MainScreen(
    userData: UserData?,
    onImageClick: () -> Unit
) {
    Scaffold (
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(16.dp),
                title = {
                    Row(
                        modifier = Modifier
                            .height(50.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            "Sample App"
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        if (userData?.profilePictureUrl != null) {
                            println("its not null")
                            AsyncImage(
                                model = userData.profilePictureUrl,
                                contentDescription = "Profile picture",
                                modifier = Modifier
                                    .size(50.dp)
                                    .clip(
                                        RoundedCornerShape(18.dp)
                                    )
                                    .clickable(
                                        onClick = onImageClick
                                    )
                            )
                        } else {
                            println("its null")
                            Box(
                                modifier = Modifier
                                    .size(50.dp)
                                    .clip(
                                        RoundedCornerShape(18.dp)
                                    )
                                    .background(color = Color.Black.copy(alpha = 0.5f))
                                    .clickable(onClick = onImageClick)
                            ) {
                                // Add default user photo here
                            }
                        }
                        Spacer(modifier = Modifier.weight(0.01f))
                    }
                }
            )
        },
        content = {innerPadding ->
            Column(
                modifier = Modifier
                    .consumeWindowInsets(innerPadding)
                    .fillMaxSize(),
            ) {

            }
        }
    )
}