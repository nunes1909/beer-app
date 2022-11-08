package com.gabriel.domain.beer.repository

import com.gabriel.domain.beer.model.Beer

interface GetSingleBeerRepository {
    suspend fun getSingleBeer(beerId: Int): Beer
}
