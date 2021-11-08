package com.gedar0082.domain.repos

import com.gedar0082.domain.entities.Episode
import com.gedar0082.domain.entities.EpisodeFilter
import com.gedar0082.domain.entities.EpisodeWrapper
import retrofit2.Response

interface EpisodeRepo {

    suspend fun getAllEpisodes(page: Int): Response<EpisodeWrapper>

    suspend fun getEpisode(id: Int): Response<Episode>

    suspend fun getEpisodesByFilter(filter: EpisodeFilter): Response<EpisodeWrapper>

}