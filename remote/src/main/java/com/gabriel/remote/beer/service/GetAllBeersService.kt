package com.gabriel.remote.beer.service

import com.gabriel.remote.beer.model.BeerRemote
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GetAllBeersService {
    @GET("beers")
    suspend fun getAll(
        @Query("per_page")
        limitePages: Int = 80,
        @Query("beer_name")
        query: String? = null
    ): Response<List<BeerRemote>>
}
