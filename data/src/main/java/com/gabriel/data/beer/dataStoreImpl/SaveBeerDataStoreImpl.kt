package com.gabriel.data.beer.dataStoreImpl

import com.gabriel.data.beer.dataSource.SaveBeerRemoteDataSource
import com.gabriel.data.beer.dataStore.SaveBeerDataStore
import com.gabriel.data.beer.model.BeerData

class SaveBeerDataStoreImpl(private val dataSource: SaveBeerRemoteDataSource) : SaveBeerDataStore {
    override suspend fun saveBeer(beer: BeerData) {
        return dataSource.saveBeer(beer)
    }
}
