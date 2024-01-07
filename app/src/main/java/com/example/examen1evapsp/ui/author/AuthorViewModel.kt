package com.example.examen1evapsp.ui.author

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.examen1evapsp.data.entities.Author
import com.example.examen1evapsp.data.entities.Car
import com.example.examen1evapsp.data.repository.CommonAuthorRepository
import com.example.examen1evapsp.ui.cars.CarViewModel
import com.example.examen1evapsp.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AuthorViewModelFactory(
    private val authorRepository: CommonAuthorRepository
): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return AuthorViewModel(authorRepository) as T
    }
}

class AuthorViewModel(
    private val authorRepository: CommonAuthorRepository
): ViewModel() {
    private val _authors = MutableLiveData<Resource<List<Author>>>()
    val authors: LiveData<Resource<List<Author>>> get() = _authors

    private val _created = MutableLiveData<Resource<Integer>>();
    val created: LiveData<Resource<Integer>> get() = _created;


    suspend fun getAllAuthors(): Resource<List<Author>>{
        return withContext(Dispatchers.IO){
            authorRepository.getAuthors()
        }
    }
    fun updateAuthor(){
        viewModelScope.launch {
            val repoResponse = getAllAuthors()
            _authors.value = repoResponse
        }
    }
}