package com.info.odevdeneme1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CustomPerson(
    val person: Person,
    val answer1: String,
    val answer2: String,
    val answer3: String
) : Parcelable
