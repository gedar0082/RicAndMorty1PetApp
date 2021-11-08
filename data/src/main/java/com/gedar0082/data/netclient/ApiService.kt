package com.gedar0082.data.netclient

import com.gedar0082.domain.entities.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap


interface ApiService {

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: Int): Response<Character>

    @GET("character")
    suspend fun getAllCharacters(@Query("page") page: Int): Response<CharacterWrapper>

    @GET("character")
    suspend fun getCharactersByFilter(
        @QueryMap parameters: Map<String, String>, @Query("page") page: Int)
    : Response<CharacterWrapper>

    @GET("location/{id}")
    suspend fun getLocation(@Path("id") id: Int): Response<Location>

    @GET("location")
    suspend fun getAllLocations(@Query("page") page: Int): Response<LocationWrapper>

    @GET("location")
    suspend fun getLocationsByFilter(
        @QueryMap parameters: Map<String, String>, @Query("page") page: Int)
            : Response<LocationWrapper>

    @GET("episode/{id}")
    suspend fun getEpisode(@Path("id") id: Int): Response<Episode>

    @GET("episode")
    suspend fun getAllEpisodes(@Query("page") page: Int): Response<EpisodeWrapper>

    @GET("episode")
    suspend fun getEpisodesByFilter(
        @QueryMap parameters: Map<String, String>, @Query("page") page: Int)
            : Response<EpisodeWrapper>


}