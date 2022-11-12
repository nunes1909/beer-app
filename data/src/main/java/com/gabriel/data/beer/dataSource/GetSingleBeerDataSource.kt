package com.gabriel.data.beer.dataSource

import com.gabriel.data.beer.model.BeerData
import com.gabriel.strategy.resource.ResourceState

interface GetSingleBeerDataSource {
    suspend fun getSingleBeer(beerId: Int): ResourceState<BeerData>
}
