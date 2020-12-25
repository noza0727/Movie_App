package com.learning.myapplication

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movies(
    val previewImage: Int,
    val pg_age: String,
    val genre: String,
    val rating: Int,
    val reviews: String,
    val title: String,
    val duration: String,
    val description: String,
    val actors: List<Actors> = emptyList()
) : Parcelable
