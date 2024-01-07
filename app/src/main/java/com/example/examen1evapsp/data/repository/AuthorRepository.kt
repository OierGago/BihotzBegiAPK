package com.example.examen1evapsp.data.repository

class AuthorRepository(private val repository: CommonAuthorRepository) {
    suspend fun getAuthors() = repository.getAuthors()
}