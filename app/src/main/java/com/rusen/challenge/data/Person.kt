package com.rusen.challenge.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    val name: String,
    val surname: String,
    val phone: String,
    val mail: String
) : Parcelable
