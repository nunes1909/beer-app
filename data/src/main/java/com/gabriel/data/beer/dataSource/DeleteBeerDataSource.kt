package com.gabriel.data.beer.dataSource

import com.gabriel.data.beer.model.BeerData

interface DeleteBeerDataSource {
    suspend fun deleteBeer(beer: BeerData)
}
