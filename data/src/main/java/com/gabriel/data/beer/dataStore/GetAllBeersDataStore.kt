package com.gabriel.data.beer.dataStore

import com.gabriel.data.beer.model.BeerData
import com.gabriel.strategy.resource.ResourceState

interface GetAllBeersDataStore {
    suspend fun getAll(query: String?): ResourceState<List<BeerData>>
}
