package com.gabriel.data.beer.dataStoreImpl

import com.gabriel.data.beer.dataSource.GetStoredBeersDataSource
import com.gabriel.data.beer.dataStore.GetStoredBeersDataStore
import com.gabriel.data.beer.model.BeerData

class GetStoredBeersDataStoreImpl(private val dataSource: GetStoredBeersDataSource) :
    GetStoredBeersDataStore {
    override suspend fun getAll(): List<BeerData> {
        return dataSource.getAll()
    }
}
