package com.example.examen1evapsp.ui.cars

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.examen1evapsp.data.entities.Car
import com.example.examen1evapsp.data.remote.RemoteCarDataSource
import com.example.examen1evapsp.databinding.CarsActivityBinding
import com.example.examen1evapsp.ui.car.CarActivity
import com.example.examen1evapsp.utils.Resource


class CarsActivity : ComponentActivity() {

    private lateinit var carsAdapter: CarAdapter

    // TODO inicializar el repositorio o repositorios
    private val carsRepository = RemoteCarDataSource();

    // TODO inicializar el viewModel
    private val viewModel: CarsViewModel by viewModels {
        CarsViewModelFactory(
            carsRepository
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = CarsActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        carsAdapter = CarAdapter(::onCarListClickItem)
        binding.carsList.adapter = carsAdapter;
        // TODO realizar toda la logica pendiente...
        viewModel.items.observe(this,Observer{
            Log.i("PruebasDia1", "ha ocurrido un cambio en la lista")
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    if (!it.data.isNullOrEmpty()) {
                        Log.e("prueba", "esto que es")
                        carsAdapter.submitList(it.data)

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
                    viewModel.updateCarList()
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




    // este metodo ya hace lo que tiene que hacer
    private fun onCarListClickItem(car: Car) {
        Log.i("examen", "onCarListClickItem")
        val intent = Intent(this, CarActivity::class.java).apply {
            putExtra("idCar", car.id)
        }
        startActivity(intent)
    }
}