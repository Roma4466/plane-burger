package com.example.plane_burger

import androidx.annotation.StringRes

data class Photo(
    val imageRes: Int,
    val title: String,
    val year: String,
    val description: String,
    val titleDescription: String,
    val photoDescription: Int?,
)