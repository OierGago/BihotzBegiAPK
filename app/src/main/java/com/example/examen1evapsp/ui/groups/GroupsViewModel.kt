package com.example.examen1evapsp.ui.groups

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.examen1evapsp.data.entities.Groups
import com.example.examen1evapsp.utils.Resource
import kotlinx.coroutines.launch

class GroupsViewModelFactory(
): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return GroupsViewModel() as T
    }
}

class GroupsViewModel(
): ViewModel() {
    private var _groups = MutableLiveData<Resource<List<Groups>>>()
    val groups : LiveData<Resource<List<Groups>>> get() = _groups


}
