package com.tcs.coffee.data.network.api

import com.tcs.coffee.data.model.response.Coffee
import com.tcs.coffee.utils.Constants.HOT_COFFEES_ENDPOINT
import com.tcs.coffee.utils.Constants.ICED_COFFEES_ENDPOINT
import retrofit2.http.GET

interface ApiService {

    @GET(HOT_COFFEES_ENDPOINT)
    suspend fun getHotCoffees(): List<Coffee>

    @GET(ICED_COFFEES_ENDPOINT)
    suspend fun getIcedCoffees(): List<Coffee>

}