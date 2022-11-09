package com.gabriel.data.beer.dataSource

import com.gabriel.data.beer.model.BeerData

interface GetStoredBeersDataSource {
    suspend fun getAll(): List<BeerData>
}
