package com.gabriel.data.beer.repository

import com.gabriel.data.beer.dataStore.DeleteBeerDataStore
import com.gabriel.data.beer.mapper.BeerDataMapper
import com.gabriel.domain.beer.model.Beer
import com.gabriel.domain.beer.repository.DeleteBeerRepository

class DeleteBeerRepositoryImpl(
    private val dataStore: DeleteBeerDataStore,
    private val mapper: BeerDataMapper
) : DeleteBeerRepository {
    override suspend fun deleteBeer(beer: Beer) {
        val beerData = mapper.mapToData(beer)
        return dataStore.deleteBeer(beer = beerData)
    }
}
