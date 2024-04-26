package com.example.examen1evapsp.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras

class LoginViewModelFactory(
): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return LoginViewModel() as T
    }
}

class LoginViewModel(
): ViewModel() {
}