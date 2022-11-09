package com.gabriel.data.beer.repository

import com.gabriel.data.beer.dataStore.SaveBeerDataStore
import com.gabriel.data.beer.mapper.BeerDataMapper
import com.gabriel.domain.beer.model.Beer
import com.gabriel.domain.beer.repository.SaveBeerRepository

class SaveBeerRepositoryImpl(
    private val dataStore: SaveBeerDataStore,
    private val mapper: BeerDataMapper
) : SaveBeerRepository {
    override suspend fun saveBeer(beer: Beer) {
        val beerData = mapper.mapToData(beer)
        return dataStore.saveBeer(beerData)
    }
}
