package com.example.examen1evapsp.data.repository

import com.example.examen1evapsp.data.entities.Book
import com.example.examen1evapsp.utils.Resource

interface CommonBookRepository {
    suspend fun getBooksByAuthorId(authorId:Int): Resource<List<Book>>
}