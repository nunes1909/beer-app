package com.gabriel.data.beer.dataSource

import com.gabriel.data.beer.model.BeerData

interface SaveBeerRemoteDataSource {
    suspend fun saveBeer(beer: BeerData)
}
