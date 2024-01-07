package com.example.examen1evapsp.data.repository

import com.example.examen1evapsp.data.entities.Reparation
import com.example.examen1evapsp.utils.Resource
import retrofit2.Response

interface CommonReparationRepository {
    suspend fun getReparationByCarId( id: Int): Resource<List<Reparation>>
    suspend fun createReparationByCarId(id: Int): Resource<Reparation>
    suspend fun deleteReparation(id: Int):Resource<Int>

}