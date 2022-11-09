package com.gabriel.data.beer.dataStoreImpl

import com.gabriel.data.beer.dataSource.GetSingleBeerDataSource
import com.gabriel.data.beer.dataStore.GetSingleBeerDataStore
import com.gabriel.data.beer.model.BeerData

class GetSingleBeerDataStoreImpl(private val dataSource: GetSingleBeerDataSource) :
    GetSingleBeerDataStore {
    override suspend fun getSingleBeer(beerId: Int): BeerData {
        return dataSource.getSingleBeer(beerId)
    }
}
