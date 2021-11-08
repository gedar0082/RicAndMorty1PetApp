package com.gedar0082.domain.repos

import com.gedar0082.domain.entities.Location
import com.gedar0082.domain.entities.LocationFilter
import com.gedar0082.domain.entities.LocationWrapper
import retrofit2.Response

interface LocationRepo {

    suspend fun getAllLocations(page: Int): Response<LocationWrapper>

    suspend fun getLocation(id: Int): Response<Location>

    suspend fun getLocationsByFilter(filter: LocationFilter): Response<LocationWrapper>

}