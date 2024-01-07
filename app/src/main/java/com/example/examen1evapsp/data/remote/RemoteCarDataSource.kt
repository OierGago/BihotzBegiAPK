package com.example.examen1evapsp.data.remote

import com.example.examen1evapsp.data.entities.Car
import com.example.examen1evapsp.data.repository.CommonCarRepository

class RemoteCarDataSource : BaseDataSource(), CommonCarRepository {

    override suspend fun getCars()= getResult {
        RetrofitClient.apiInterface.getCars()
    }
    override suspend fun getCarById(id: Int)= getResult {
        RetrofitClient.apiInterface.getCarById(id)
    }
    override suspend fun updateCar(car: Car)= getResult {
        RetrofitClient.apiInterface.updateCar(car)
            }
    override suspend fun createCar(car: Car)= getResult {
    RetrofitClient.apiInterface.createCar(car)
    }


}