package com.gabriel.data.beer.dataStore

import com.gabriel.data.beer.model.BeerData
import com.gabriel.domain.util.resource.ResourceState

interface GetSingleBeerDataStore {
    suspend fun getSingleBeer(beerId: Int): ResourceState<BeerData>
}
