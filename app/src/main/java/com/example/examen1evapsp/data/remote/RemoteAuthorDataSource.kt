package com.example.examen1evapsp.data.remote

import com.example.examen1evapsp.data.entities.Author
import com.example.examen1evapsp.data.repository.CommonAuthorRepository
import com.example.examen1evapsp.utils.Resource

class RemoteAuthorDataSource:  BaseDataSource(), CommonAuthorRepository  {
    override suspend fun getAuthors(): Resource<List<Author>> {
        TODO("Not yet implemented")
        RetrofitClient.apiInterface.getAuthors()
    }
}