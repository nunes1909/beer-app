package com.gabriel.data.beer.dataSource

import com.gabriel.data.beer.model.BeerData

interface GetSingleBeerDataSource {
    suspend fun getSingleBeer(beerId: Int): BeerData
}
