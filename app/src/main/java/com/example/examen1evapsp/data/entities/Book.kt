package com.example.examen1evapsp.data.entities

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import java.time.LocalDate

@Parcelize
data class Book (
    val id:Int,
    val isbn:String,
    val title:String,
    val authorId: Int,
    val editorial: String,
    val category: String,
    val page: Int,
    val price: Double,
    val score: Int,
    val releaseDate: LocalDate,
    val lang: String
): Parcelable