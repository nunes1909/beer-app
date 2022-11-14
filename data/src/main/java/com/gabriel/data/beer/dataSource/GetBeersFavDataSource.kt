package com.gabriel.data.beer.dataSource

import com.gabriel.data.beer.model.BeerData
import com.gabriel.strategy.resource.ResourceState

interface GetBeersFavDataSource {
    suspend fun getBeersFav(): ResourceState<List<BeerData>>
}
