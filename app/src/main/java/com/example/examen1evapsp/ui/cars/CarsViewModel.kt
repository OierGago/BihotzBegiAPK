package com.example.examen1evapsp.ui.cars

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.examen1evapsp.data.entities.Car
import com.example.examen1evapsp.data.repository.CommonCarRepository
import com.example.examen1evapsp.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
// TODO tiene parametros de entrada o no?
class CarsViewModelFactory(
    private val carRepository: CommonCarRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return CarsViewModel(carRepository) as T
    }
}

// TODO tiene parametros de entrada o no?
class CarsViewModel(
    private val carRepository: CommonCarRepository
) : ViewModel() {
    // TODO aqui falta todo

    private val _items = MutableLiveData<Resource<List<Car>>>()
    val items: LiveData<Resource<List<Car>>> get() = _items

    private val _created = MutableLiveData<Resource<Integer>>();
    val created: LiveData<Resource<Integer>> get() = _created;

    init {
        updateCarList()
    }

    fun updateCarList() {
        viewModelScope.launch {
            // lista a mano
            // voy a llamar a la funcion
            // que va a solicitar los empleados del repositorio
            val repoResponse = getCarsFromRepository();
            // cambiamos el valor de mutableLiveData
            _items.value = repoResponse
        }
    }
    suspend fun getCarsFromRepository(): Resource<List<Car>>{
        return withContext(Dispatchers.IO){
            carRepository.getCars()
        }
    }
    suspend fun getCarFromRepositoryById(id:Int): Resource<Car>{
        return withContext(Dispatchers.IO){
            carRepository.getCarById(id)
        }
    }


}
