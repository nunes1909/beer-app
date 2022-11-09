package com.gabriel.data.beer.dataStore

import com.gabriel.data.beer.model.BeerData

interface SaveBeerDataStore {
    suspend fun saveBeer(beer: BeerData)
}
