package com.example.examen1evapsp.ui.cars

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.examen1evapsp.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
// TODO tiene parametros de entrada o no?
class CarsViewModelFactory(

): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return CarsViewModel() as T
    }
}

// TODO tiene parametros de entrada o no?
class CarsViewModel(

) : ViewModel() {
    // TODO aqui falta todo
}
