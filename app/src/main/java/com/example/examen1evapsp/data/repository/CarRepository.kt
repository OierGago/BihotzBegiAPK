package com.example.examen1evapsp.data.repository

import com.example.examen1evapsp.data.entities.Car
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Path

class CarRepository(private val repository: CommonCarRepository) {
    suspend fun getCars() = repository.getCars()
    suspend fun getCarById( id:Int)= repository.getCarById(id)
    suspend fun createCar( car: Car)= repository.createCar(car)
    suspend fun updateCar(car: Car)= repository.updateCar(car)

}