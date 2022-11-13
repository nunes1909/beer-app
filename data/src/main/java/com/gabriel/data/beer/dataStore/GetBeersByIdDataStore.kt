package com.gabriel.data.beer.dataStore

import com.gabriel.data.beer.model.BeerData
import com.gabriel.strategy.resource.ResourceState

interface GetBeersByIdDataStore {
    suspend fun getBeersById(): ResourceState<List<BeerData>>
}
