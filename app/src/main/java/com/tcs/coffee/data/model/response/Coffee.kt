package com.tcs.coffee.data.model.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Coffee(
    val title: String?,
    val description: String?,
    val ingredients: List<String>?,
    val image: String?,
    val id: String?
) : Parcelable
