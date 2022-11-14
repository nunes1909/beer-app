package com.gabriel.data.beer.dataSource

import com.gabriel.data.beer.model.BeerData
import com.gabriel.strategy.resource.ResourceState

interface GetAllBeersDataSource {
    suspend fun getAll(query: String?): ResourceState<List<BeerData>>
}
