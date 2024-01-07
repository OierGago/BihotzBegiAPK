package com.example.examen1evapsp.data.remote

import com.example.examen1evapsp.data.entities.Book
import com.example.examen1evapsp.data.repository.CommonBookRepository
import com.example.examen1evapsp.data.repository.CommonCarRepository
import com.example.examen1evapsp.utils.Resource

class RemoteBookDataSource:  BaseDataSource(), CommonBookRepository {
    override suspend fun getBooksByAuthorId(authorId: Int): Resource<List<Book>> {
        TODO("Not yet implemented")
        RetrofitClient.apiInterface.getBookByAuthorId(authorId)
    }
}