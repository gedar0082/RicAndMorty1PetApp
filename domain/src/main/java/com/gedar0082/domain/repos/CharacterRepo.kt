package com.gedar0082.domain.repos

import com.gedar0082.domain.entities.Character
import com.gedar0082.domain.entities.CharacterFilter
import com.gedar0082.domain.entities.CharacterWrapper
import retrofit2.Response

interface CharacterRepo {

    suspend fun getAllCharacters(page: Int): Response<CharacterWrapper>

    suspend fun getCharacter(id: Int): Response<Character>

    suspend fun getCharactersByFilter(filter: CharacterFilter): Response<CharacterWrapper>
}