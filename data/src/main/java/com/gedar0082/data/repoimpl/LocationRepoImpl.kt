package com.gedar0082.data.repoimpl

import com.gedar0082.data.netclient.ApiService
import com.gedar0082.data.netclient.NetClient
import com.gedar0082.domain.entities.Location
import com.gedar0082.domain.entities.LocationFilter
import com.gedar0082.domain.entities.LocationWrapper
import com.gedar0082.domain.repos.LocationRepo
import retrofit2.Response

class LocationRepoImpl(private val net: ApiService): LocationRepo {
    override suspend fun getAllLocations(page: Int): Response<LocationWrapper> {
        return net.getAllLocations(page)
    }

    override suspend fun getLocation(id: Int): Response<Location> {
        return net.getLocation(id)
    }

    override suspend fun getLocationsByFilter(filter: LocationFilter): Response<LocationWrapper> {
        return net.getLocationsByFilter(filter.getMap(), filter.page)
    }
}