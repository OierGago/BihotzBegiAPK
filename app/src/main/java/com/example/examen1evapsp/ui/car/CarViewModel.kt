package com.example.examen1evapsp.ui.cars

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.examen1evapsp.data.entities.Car
import com.example.examen1evapsp.data.entities.Reparation
import com.example.examen1evapsp.data.repository.CommonCarRepository
import com.example.examen1evapsp.data.repository.CommonReparationRepository
import com.example.examen1evapsp.data.repository.ReparationRepository
import com.example.examen1evapsp.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// TODO tiene parametros de entrada o no?
class CarViewModelFactory(
    private val carReparationRepository: CommonReparationRepository,
    private val carRepository: CommonCarRepository

): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return CarViewModel(carReparationRepository,carRepository) as T
    }
}

// TODO tiene parametros de entrada o no?
class CarViewModel(
    private val carReparationRepository: CommonReparationRepository,
    private val carRepository: CommonCarRepository

) : ViewModel() {
    private val _items = MutableLiveData<Resource<List<Reparation>>>()
    val items: LiveData<Resource<List<Reparation>>> get() = _items

    private val _cars = MutableLiveData<Resource<Car>>()
    val cars: LiveData<Resource<Car>> get() = _cars

    private val _created = MutableLiveData<Resource<Integer>>();
    val created: LiveData<Resource<Integer>> get() = _created;


    fun updateCar(id:Int){
        viewModelScope.launch {
            // lista a mano
            // voy a llamar a la funcion
            // que va a solicitar los empleados del repositorio
            val repoResponse = getReparationsById(id);
            // cambiamos el valor de mutableLiveData
            _items.value = repoResponse
        }
    }
    suspend fun getCarFromRepositoryById(id:Int): Resource<Car>{
        return withContext(Dispatchers.IO){
            carRepository.getCarById(id)
        }
    }
    suspend fun getReparationsById(id:Int): Resource<List<Reparation>> {
        return withContext(Dispatchers.IO){
            carReparationRepository.getReparationByCarId(id)
        }
    }
}
