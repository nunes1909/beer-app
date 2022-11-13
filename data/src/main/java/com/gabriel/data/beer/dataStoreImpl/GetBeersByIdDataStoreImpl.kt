package com.gabriel.data.beer.dataStoreImpl

import com.gabriel.data.beer.dataSource.GetBeersByIdDataSource
import com.gabriel.data.beer.dataStore.GetBeersByIdDataStore
import com.gabriel.data.beer.model.BeerData
import com.gabriel.strategy.resource.ResourceState

class GetBeersByIdDataStoreImpl(private val dataSource: GetBeersByIdDataSource) :
    GetBeersByIdDataStore {
    override suspend fun getBeersById(): ResourceState<List<BeerData>> {
        return dataSource.getBeersById()
    }
}
