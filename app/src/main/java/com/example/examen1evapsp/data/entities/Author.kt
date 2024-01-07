package com.example.examen1evapsp.data.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Author (
    val id : Int,
    val name: String

): Parcelable