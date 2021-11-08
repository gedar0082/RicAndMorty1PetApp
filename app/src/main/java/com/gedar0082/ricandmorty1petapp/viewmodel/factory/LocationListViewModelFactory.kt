package com.gedar0082.ricandmorty1petapp.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gedar0082.domain.repos.LocationRepo

class LocationListViewModelFactory (private val repo: LocationRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(LocationRepo::class.java).newInstance(repo)
    }
}