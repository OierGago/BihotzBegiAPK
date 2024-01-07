package com.example.examen1evapsp.data.repository

import com.example.examen1evapsp.data.entities.Author
import com.example.examen1evapsp.utils.Resource

interface CommonAuthorRepository {
    suspend fun getAuthors() : Resource<List<Author>>

}