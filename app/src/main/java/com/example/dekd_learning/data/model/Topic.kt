package com.example.dekd_learning.data.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val stringResourceId: Int,
    val students: Int,
    @DrawableRes val imageResourceId: Int
)