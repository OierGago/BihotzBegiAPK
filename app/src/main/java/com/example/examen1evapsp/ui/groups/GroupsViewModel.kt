package com.example.examen1evapsp.ui.groups

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras

class GroupsViewModelFactory(
): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return GroupsViewModel() as T
    }
}

class GroupsViewModel(
): ViewModel() {
}