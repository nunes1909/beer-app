package com.gabriel.data.beer.dataSource

interface DeleteBeerDataSource {
    suspend fun deleteBeer(beerId: Int)
}
