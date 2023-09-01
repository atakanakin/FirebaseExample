package com.atakan.firebaseexample.presentation.character

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.atakan.firebaseexample.domain.model.Character

@Composable
fun CharactersScreen(
    characterList: List<Character>
) {
    LazyColumn{
        items(characterList.size){ item ->
            Character(character = characterList[item])
            Box(
                modifier = Modifier.height(10.dp)
            )
        }
    }
}