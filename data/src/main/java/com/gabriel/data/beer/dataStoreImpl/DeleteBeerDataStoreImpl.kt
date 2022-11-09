package com.gabriel.data.beer.dataStoreImpl

import com.gabriel.data.beer.dataSource.DeleteBeerDataSource
import com.gabriel.data.beer.dataStore.DeleteBeerDataStore
import com.gabriel.data.beer.model.BeerData

class DeleteBeerDataStoreImpl(private val dataSource: DeleteBeerDataSource) : DeleteBeerDataStore {
    override suspend fun deleteBeer(beer: BeerData) {
        return dataSource.deleteBeer(beer = beer)
    }
}