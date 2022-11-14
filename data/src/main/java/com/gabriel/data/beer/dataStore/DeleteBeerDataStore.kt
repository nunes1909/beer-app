package com.gabriel.data.beer.dataStore

interface DeleteBeerDataStore {
    suspend fun deleteBeer(beerId: Int)
}
