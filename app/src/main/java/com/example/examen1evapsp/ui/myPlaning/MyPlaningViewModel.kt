package com.example.examen1evapsp.ui.myPlaning

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras

class MyPlaningViewModelFactory(
): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return MyPlaningViewModel() as T
    }
}

class MyPlaningViewModel(
): ViewModel() {
}