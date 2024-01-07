package com.example.examen1evapsp.data.repository

class BookRepository(private val repository: CommonBookRepository) {
    suspend fun  getBooksByAuthorId(authorId:Int) = repository.getBooksByAuthorId(authorId)
}