package com.gedar0082.ricandmorty1petapp.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gedar0082.domain.repos.EpisodeRepo

class EpisodeListViewModelFactory (private val repo: EpisodeRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(EpisodeRepo::class.java).newInstance(repo)
    }
}