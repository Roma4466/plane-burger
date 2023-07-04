package com.example.plane_burger

import androidx.annotation.StringRes

data class Photo(
    val imageRes: Int,
    @StringRes val title: Int,
    @StringRes val year: Int,
    @StringRes val description: Int,
    @StringRes val titleDescription: Int,
    val photoDescription: Int?,
)