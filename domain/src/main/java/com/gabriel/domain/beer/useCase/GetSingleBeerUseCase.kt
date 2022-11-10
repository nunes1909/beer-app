package com.gabriel.domain.beer.useCase

import com.gabriel.domain.beer.model.Beer
import com.gabriel.domain.util.resource.ResourceState

interface GetSingleBeerUseCase {
    suspend fun getSingleBeer(beerId: Int): ResourceState<Beer>
}
