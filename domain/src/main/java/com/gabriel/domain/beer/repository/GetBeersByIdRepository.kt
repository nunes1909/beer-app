package com.gabriel.domain.beer.repository

import com.gabriel.domain.beer.model.Beer
import com.gabriel.strategy.resource.ResourceState

interface GetBeersByIdRepository {
    suspend fun getBeersById(): ResourceState<List<Beer>>
}
