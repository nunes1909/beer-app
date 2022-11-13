package com.gabriel.data.beer.dataStoreImpl

import com.gabriel.data.beer.dataSource.GetSingleBeerDataSource
import com.gabriel.data.beer.dataStore.GetSingleBeerDataStore
import com.gabriel.data.beer.model.BeerData
import com.gabriel.strategy.resource.ResourceState

class GetSingleBeerDataStoreImpl(private val dataSource: GetSingleBeerDataSource) :
    GetSingleBeerDataStore {
    override suspend fun getSingleBeer(beerId: Int): ResourceState<BeerData> {
        return dataSource.getSingleBeer(beerId)
    }
}
