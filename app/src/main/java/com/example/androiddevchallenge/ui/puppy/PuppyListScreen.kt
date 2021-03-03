package com.example.androiddevchallenge.ui.puppy

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.ui.theme.typography

@Composable
fun PuppyListScreen(navController: NavController) {
    val description = "puppy description"
    val puppies = listOf(
        Puppy("reo", description, R.drawable.pexels_chevanon_photography_1108099),
        Puppy("cherry", description, R.drawable.pexels_tanika_3687770),
        Puppy("shiro", description, R.drawable.pexels_valeria_boltneva_1805164)
    )
    LazyColumn() {
        items(items = puppies) { poppy ->
            PuppyItem(poppy) {
                navController.currentBackStackEntry?.arguments?.putParcelable("puppy", it)
                navController.navigate("puppyDetail")
            }
            Divider(color = Color.Black)
        }
    }
}

@Composable
fun PuppyItem(puppy: Puppy, onClicked: (Puppy) -> Unit) {
    Row(modifier = Modifier.clickable { onClicked(puppy) }) {
        val imageModifier = Modifier
            .width(80.dp)
            .height(80.dp)
            .clip(shape = RoundedCornerShape(2.dp))
        Image(
            painter = painterResource(id = puppy.imageResId),
            contentDescription = "",
            modifier = imageModifier,
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = puppy.name,
            style = typography.h6,
            modifier = Modifier
                .padding(start = 16.dp)
                .fillMaxWidth()
        )
    }
}