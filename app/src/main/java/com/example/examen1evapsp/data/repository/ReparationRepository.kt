package com.example.examen1evapsp.data.repository

import com.example.examen1evapsp.data.entities.Reparation
import retrofit2.Response
import retrofit2.http.Path

class ReparationRepository(private val repository: CommonReparationRepository) {
    suspend fun getReparationByCarId( id: Int) = repository.getReparationByCarId(id)
    suspend fun createReparationByCarId(id: Int)= repository.createReparationByCarId(id)
    suspend fun deleteReparation(id: Int)= repository.deleteReparation(id)

}