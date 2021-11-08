package com.gedar0082.ricandmorty1petapp.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gedar0082.domain.repos.CharacterRepo

class CharacterListViewModelFactory (private val repo: CharacterRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(CharacterRepo::class.java).newInstance(repo)
    }
}