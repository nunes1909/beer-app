package com.gabriel.domain.beer.useCase

import com.gabriel.domain.beer.model.Beer
import com.gabriel.strategy.resource.ResourceState

interface GetSingleBeerUseCase {
    suspend fun getSingleBeer(beerId: Int): ResourceState<Beer>
}
