package com.example.examen1evapsp.ui.pantallaCarga

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras

class PantallaCargaViewModelFactory(
): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return PantallaCargaViewModel() as T
    }
}

class PantallaCargaViewModel(
): ViewModel() {
}