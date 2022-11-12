package com.gabriel.data.beer.repository

import com.gabriel.data.beer.dataStore.GetSingleBeerDataStore
import com.gabriel.data.beer.mapper.BeerDataMapper
import com.gabriel.domain.beer.model.Beer
import com.gabriel.domain.beer.repository.GetSingleBeerRepository
import com.gabriel.strategy.resource.ResourceState

class GetSingleBeerRepositoryImpl(
    private val dataStore: GetSingleBeerDataStore,
    private val mapper: BeerDataMapper
) : GetSingleBeerRepository {
    override suspend fun getSingleBeer(beerId: Int): ResourceState<Beer> {
        val resourcetData = dataStore.getSingleBeer(beerId)
        if (resourcetData.data != null) {
            val resultData = mapper.mapToDomain(resourcetData.data!!)
            return ResourceState.Success(resultData)
        }
        return ResourceState.Error(cod = resourcetData.cod, message = resourcetData.message)
    }
}
