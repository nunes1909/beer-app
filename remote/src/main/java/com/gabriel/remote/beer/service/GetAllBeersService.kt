package com.gabriel.remote.beer.service

import com.gabriel.remote.beer.model.BeerRemote
import retrofit2.Response
import retrofit2.http.GET

interface GetAllBeersService {
    @GET("beers")
    suspend fun getAll(): Response<List<BeerRemote>>
}
