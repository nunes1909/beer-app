package com.gabriel.remote.beer.service

import com.gabriel.remote.beer.model.BeerRemote
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GetBeersByIdService {
    @GET
    suspend fun getSingleBeer(
        @Query("ids") beerId: String
    ): Response<List<BeerRemote>>
}
