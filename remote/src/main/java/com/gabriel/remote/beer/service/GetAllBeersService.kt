package com.gabriel.remote.beer.service

import com.gabriel.domain.util.constants.ConstantsUtil.BEERS_URL
import com.gabriel.remote.beer.model.BeerRemote
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GetAllBeersService {
    @GET(BEERS_URL)
    suspend fun getAll(
        @Query("per_page") limitePages: Int = 80
    ): Response<List<BeerRemote>>
}
