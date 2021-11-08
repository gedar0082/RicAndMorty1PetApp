package com.gedar0082.data.repoimpl

import com.gedar0082.data.netclient.ApiService

import com.gedar0082.domain.entities.Character
import com.gedar0082.domain.entities.CharacterFilter
import com.gedar0082.domain.entities.CharacterWrapper
import com.gedar0082.domain.repos.CharacterRepo
import retrofit2.Response

class CharacterRepoImpl(private val net: ApiService) : CharacterRepo {

    override suspend fun getAllCharacters(page: Int): Response<CharacterWrapper> {
        return net.getAllCharacters(page)
    }

    override suspend fun getCharacter(id: Int): Response<Character> {
        return net.getCharacter(id)
    }

    override suspend fun getCharactersByFilter(filter: CharacterFilter): Response<CharacterWrapper> {
        return net.getCharactersByFilter(filter.getMap(), filter.page)
    }
}