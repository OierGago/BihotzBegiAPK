package com.example.examen1evapsp.ui.car

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.examen1evapsp.data.entities.Reparation
import com.example.examen1evapsp.data.remote.RemoteCarDataSource
import com.example.examen1evapsp.data.remote.RemoteReparationDataSource
import com.example.examen1evapsp.databinding.CarActivityBinding
import com.example.examen1evapsp.ui.cars.CarViewModel
import com.example.examen1evapsp.ui.cars.CarViewModelFactory
import com.example.examen1evapsp.ui.cars.CarsViewModel
import com.example.examen1evapsp.ui.cars.CarsViewModelFactory
import com.example.examen1evapsp.utils.Resource


class CarActivity : ComponentActivity() {

    private lateinit var carReparationsAdapter: CarReparationAdapter

    // TODO inicializar el repositorio o repositorios
    private val carReparationRepository = RemoteReparationDataSource();
    private val carsRepository = RemoteCarDataSource()

    // TODO inicializar el viewModel
    private val viewModel: CarViewModel by viewModels {
        CarViewModelFactory(
            carReparationRepository, carsRepository
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = CarActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        carReparationsAdapter = CarReparationAdapter(::onCarReparationListClickItem)
        binding.reparationsList.adapter = carReparationsAdapter

        val idCar = intent.getIntExtra("idCar", 0)
        Log.e("prueba", idCar.toString())
        viewModel.items.observe(this,Observer{
            Log.i("PruebasDia2", "ha ocurrido un cambio en la lista")
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    if (!it.data.isNullOrEmpty()) {
                        Log.e("prueba", "esto que es")
                        carReparationsAdapter.submitList(it.data)

                    }
                }
                Resource.Status.ERROR -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
                Resource.Status.LOADING -> {
                    // de momento
                }
            }
        })
        viewModel.created.observe(this, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    viewModel.updateCar(idCar)
                }

                Resource.Status.ERROR -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }

                Resource.Status.LOADING -> {
                    // de momento
                }
            }
        })
    }

    private fun onCarReparationListClickItem(reparation: Reparation) {
        Log.i("examen", "onCarReparationListClickItem")
    }
}