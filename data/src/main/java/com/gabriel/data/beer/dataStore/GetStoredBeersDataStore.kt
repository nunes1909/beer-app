package com.gabriel.data.beer.dataStore

import com.gabriel.data.beer.model.BeerData

interface GetStoredBeersDataStore {
    suspend fun getAll(): List<BeerData>
}
