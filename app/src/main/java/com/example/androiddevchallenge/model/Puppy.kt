package com.example.androiddevchallenge.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Puppy(
    val name: String,
    val description: String,
    @DrawableRes val imageResId: Int
) : Parcelable