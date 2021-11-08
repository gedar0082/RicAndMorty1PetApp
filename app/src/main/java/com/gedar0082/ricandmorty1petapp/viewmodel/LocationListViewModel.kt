package com.gedar0082.ricandmorty1petapp.viewmodel

import androidx.lifecycle.ViewModel
import com.gedar0082.domain.entities.Location
import com.gedar0082.domain.repos.LocationRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LocationListViewModel(private val locationRepo: LocationRepo): ViewModel() {
    
    private var coroutineJob : Job? = null
    
    private val _locations = MutableStateFlow(listOf<Location>())
    val locations = _locations.asStateFlow()
    
    fun getAllLocations(page: Int){
        coroutineJob = CoroutineScope(Dispatchers.IO).launch {
            val response = locationRepo.getAllLocations(page)
            if (response.isSuccessful){
                response.body()?.let {
                    _locations.value = it.results
                }
            }else{
                _locations.value = listOf()
            }
        }
    }
    
}