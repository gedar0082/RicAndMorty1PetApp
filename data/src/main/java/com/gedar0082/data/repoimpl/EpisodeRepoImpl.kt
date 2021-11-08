package com.gedar0082.data.repoimpl

import com.gedar0082.data.netclient.ApiService
import com.gedar0082.data.netclient.NetClient
import com.gedar0082.domain.entities.Episode
import com.gedar0082.domain.entities.EpisodeFilter
import com.gedar0082.domain.entities.EpisodeWrapper
import com.gedar0082.domain.repos.EpisodeRepo
import retrofit2.Response

class EpisodeRepoImpl(private val net: ApiService): EpisodeRepo {

    override suspend fun getAllEpisodes(page: Int): Response<EpisodeWrapper> {
        return net.getAllEpisodes(page)
    }

    override suspend fun getEpisode(id: Int): Response<Episode> {
        return net.getEpisode(id)
    }

    override suspend fun getEpisodesByFilter(filter: EpisodeFilter): Response<EpisodeWrapper> {
        return net.getEpisodesByFilter(filter.getMap(), filter.page)
    }
}