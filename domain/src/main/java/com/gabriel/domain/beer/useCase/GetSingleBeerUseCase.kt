package com.gabriel.domain.beer.useCase

import com.gabriel.domain.beer.model.Beer

interface GetSingleBeerUseCase {
    suspend fun getSingleBeer(beerId: Int): Beer
}
