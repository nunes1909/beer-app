package com.gabriel.data.beer.dataStoreImpl

import com.gabriel.data.beer.dataSource.GetAllBeersDataSource
import com.gabriel.data.beer.dataStore.GetAllBeersDataStore
import com.gabriel.data.beer.model.BeerData
import com.gabriel.domain.util.resource.ResourceState

class GetAllBeersDataStoreImpl(private val dataSource: GetAllBeersDataSource) :
    GetAllBeersDataStore {
    override suspend fun getAll(query: String?): ResourceState<List<BeerData>> {
        return dataSource.getAll(query)
    }
}
