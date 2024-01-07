package com.example.examen1evapsp.data.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Date

// TODO pendiente de hacer todo
@Parcelize
data class Reparation(
    val id: Int,
    val reparationDate: Date,
    val price: Float,
    val idCar: Int): Parcelable