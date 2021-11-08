package com.gedar0082.ricandmorty1petapp.viewmodel

import androidx.lifecycle.ViewModel
import com.gedar0082.domain.entities.Episode
import com.gedar0082.domain.repos.EpisodeRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class EpisodeListViewModel(private val episodeRepo: EpisodeRepo) : ViewModel() {

    private var coroutineJob: Job? = null

    private val _episodes = MutableStateFlow(listOf<Episode>())
    val episodes = _episodes.asStateFlow()

    fun getAllEpisodes(page: Int) {
        coroutineJob = CoroutineScope(Dispatchers.IO).launch {
            val response = episodeRepo.getAllEpisodes(page)
            if (response.isSuccessful) {
                response.body()?.let {
                    _episodes.value = it.results
                }
            } else {
                _episodes.value = listOf()
            }
        }
    }
}