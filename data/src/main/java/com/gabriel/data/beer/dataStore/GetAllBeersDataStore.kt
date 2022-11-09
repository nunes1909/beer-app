package com.gabriel.data.beer.dataStore

import com.gabriel.data.beer.model.BeerData

interface GetAllBeersDataStore {
    suspend fun getAll(): List<BeerData>
}
