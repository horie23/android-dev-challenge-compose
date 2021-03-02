package com.example.androiddevchallenge.ui.puppy

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.ui.theme.typography
import java.lang.IllegalArgumentException

@Composable
fun PuppyDetailScreen(navController: NavController) {
    val puppy = navController.previousBackStackEntry?.arguments
        ?.getParcelable<Puppy>("puppy")
        ?: throw IllegalArgumentException()
    Column {
        val imageModifier = Modifier
            .height(180.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(bottomStart = 4.dp, bottomEnd = 4.dp))
        Image(
            painter = painterResource(id = puppy.imageResId),
            contentDescription = "",
            modifier = imageModifier,
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.height(16.dp))
        Text(
            text = puppy.name,
            style = typography.h6,
            modifier = Modifier.padding(start = 16.dp)
        )
        Text(
            text = "poppy description",
            style = typography.body2,
            modifier = Modifier.padding(start = 16.dp, top = 8.dp)
        )
    }
}