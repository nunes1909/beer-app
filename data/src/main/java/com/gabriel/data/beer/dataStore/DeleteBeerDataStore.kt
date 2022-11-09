package com.gabriel.data.beer.dataStore

import com.gabriel.data.beer.model.BeerData

interface DeleteBeerDataStore {
    suspend fun deleteBeer(beer: BeerData)
}
