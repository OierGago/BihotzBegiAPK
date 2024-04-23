package com.example.examen1evapsp.data.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Groups (
    val id:Int,
    val nombre:String,
    val descripcion:String,
    val isPrivate:Boolean
): Parcelable