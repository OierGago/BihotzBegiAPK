package com.example.examen1evapsp.data.remote

import com.example.examen1evapsp.data.repository.CommonReparationRepository

class RemoteReparationDataSource : BaseDataSource(), CommonReparationRepository {
    override suspend fun getReparationByCarId( id: Int) = getResult {
        RetrofitClient.apiInterface.getReparationByCarId(id)
    }
    override suspend fun createReparationByCarId(id: Int)= getResult {
        RetrofitClient.apiInterface.createReparationByCarId(id)
    }
    override suspend fun deleteReparation(id: Int)= getResult {
        RetrofitClient.apiInterface.deleteReparation(id)
    }

}