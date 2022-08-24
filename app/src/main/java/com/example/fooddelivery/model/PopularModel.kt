package com.example.fooddelivery.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PopularModel(
    val name: String,
    val image: Int,
    val price: Double,
    val description: String,
): Parcelable
