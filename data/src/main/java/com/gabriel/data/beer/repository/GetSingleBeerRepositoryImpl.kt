package com.gabriel.data.beer.repository

import com.gabriel.data.beer.dataStore.GetSingleBeerDataStore
import com.gabriel.data.beer.mapper.BeerDataMapper
import com.gabriel.domain.beer.model.Beer
import com.gabriel.domain.beer.repository.GetSingleBeerRepository

class GetSingleBeerRepositoryImpl(
    private val dataStore: GetSingleBeerDataStore,
    private val mapper: BeerDataMapper
) : GetSingleBeerRepository {
    override suspend fun getSingleBeer(beerId: Int): Beer {
        val resultData = dataStore.getSingleBeer(beerId)
        return mapper.mapToDomain(resultData)
    }
}
