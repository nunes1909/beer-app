package com.gabriel.data.beer.dataStoreImpl

import com.gabriel.data.beer.dataSource.GetBeersFavDataSource
import com.gabriel.data.beer.dataStore.GetBeersFavDataStore
import com.gabriel.data.beer.model.BeerData
import com.gabriel.strategy.resource.ResourceState

class GetBeersFavDataStoreImpl(private val dataSource: GetBeersFavDataSource) :
    GetBeersFavDataStore {
    override suspend fun getBeersFav(): ResourceState<List<BeerData>> {
        return dataSource.getBeersFav()
    }
}
