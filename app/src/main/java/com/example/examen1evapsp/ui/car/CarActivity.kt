package com.example.examen1evapsp.ui.car

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.examen1evapsp.data.entities.Reparation
import com.example.examen1evapsp.databinding.CarActivityBinding
import com.example.examen1evapsp.ui.cars.CarViewModel
import com.example.examen1evapsp.ui.cars.CarViewModelFactory
import com.example.examen1evapsp.utils.Resource


class CarActivity : ComponentActivity() {

    private lateinit var carReparationsAdapter: CarReparationAdapter

    // TODO inicializar el repositorio o repositorios

    // TODO inicializar el viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = CarActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        carReparationsAdapter = CarReparationAdapter(::onCarReparationListClickItem)
        binding.reparationsList.adapter = carReparationsAdapter

        val idCar = intent.getIntExtra("idCar", 0)

        // TODO realizar toda la logica pendiente...

    }

    private fun onCarReparationListClickItem(reparation: Reparation) {
        Log.i("examen", "onCarReparationListClickItem")
    }
}