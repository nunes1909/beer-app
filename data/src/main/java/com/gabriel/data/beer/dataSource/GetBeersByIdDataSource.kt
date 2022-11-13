package com.gabriel.data.beer.dataSource

import com.gabriel.data.beer.model.BeerData
import com.gabriel.strategy.resource.ResourceState

interface GetBeersByIdDataSource {
    suspend fun getBeersById(): ResourceState<List<BeerData>>
}
