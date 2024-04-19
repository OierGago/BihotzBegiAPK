package com.example.examen1evapsp.ui.publicos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras

class PublicosViewModelFactory(
): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return PublicosViewModel() as T
    }
}

class PublicosViewModel(
): ViewModel() {
}