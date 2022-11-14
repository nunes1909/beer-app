package com.gabriel.data.beer.dataStoreImpl

import com.gabriel.data.beer.dataSource.DeleteBeerDataSource
import com.gabriel.data.beer.dataStore.DeleteBeerDataStore

class DeleteBeerDataStoreImpl(private val dataSource: DeleteBeerDataSource) : DeleteBeerDataStore {
    override suspend fun deleteBeer(beerId: Int) {
        return dataSource.deleteBeer(beerId)
    }
}
