package com.example.examen1evapsp.data.repository

import com.example.examen1evapsp.data.entities.Car
import com.example.examen1evapsp.utils.Resource
import retrofit2.Response

interface CommonCarRepository {
    suspend fun getCars() : Resource<List<Car>>
    suspend fun getCarById( id:Int): Resource<Car>
    suspend fun createCar( car: Car): Resource<Car>
    suspend fun updateCar(car: Car): Resource<Car>

}