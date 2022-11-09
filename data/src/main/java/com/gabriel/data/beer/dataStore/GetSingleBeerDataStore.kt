package com.gabriel.data.beer.dataStore

import com.gabriel.data.beer.model.BeerData

interface GetSingleBeerDataStore {
    suspend fun getSingleBeer(beerId: Int): BeerData
}
