package com.example.examen1evapsp.data.entities

import android.os.Parcelable
import androidx.compose.ui.graphics.Color
import kotlinx.parcelize.Parcelize

// TODO pendiente de hacer todo
@Parcelize
data class Car(
    val id: Int,
    val carRegistration: String,
    val model: String,
    val color: String
): Parcelable