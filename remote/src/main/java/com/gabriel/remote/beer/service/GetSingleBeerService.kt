package com.gabriel.remote.beer.service

import com.gabriel.remote.beer.model.BeerRemote
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GetSingleBeerService {
    @GET
    suspend fun getSingleBeer(
        @Query("beerId") beerId: Int
    ): Response<BeerRemote>
}
