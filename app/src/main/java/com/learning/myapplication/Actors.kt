package com.learning.myapplication

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Actors(
    val fullName: String,
    val picture: Int
) : Parcelable