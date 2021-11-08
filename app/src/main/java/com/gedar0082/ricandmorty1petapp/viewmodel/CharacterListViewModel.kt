package com.gedar0082.ricandmorty1petapp.viewmodel

import androidx.lifecycle.ViewModel
import com.gedar0082.domain.entities.Character
import com.gedar0082.domain.repos.CharacterRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CharacterListViewModel (private val characterRepo: CharacterRepo) : ViewModel() {

    private var coroutineJob : Job? = null

    private val _characters = MutableStateFlow(listOf<Character>())
    val characters = _characters.asStateFlow()

    fun getAllCharacters(page: Int){
        coroutineJob = CoroutineScope(Dispatchers.IO).launch {
            val response = characterRepo.getAllCharacters(page)
            if (response.isSuccessful){
                response.body()?.let {
                    _characters.value = it.results
                }
            }else{
                _characters.value = listOf()
            }
        }
    }

}