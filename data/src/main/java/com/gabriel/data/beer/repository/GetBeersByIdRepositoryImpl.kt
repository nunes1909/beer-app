package com.gabriel.data.beer.repository

import com.gabriel.data.beer.dataStore.GetBeersByIdDataStore
import com.gabriel.data.beer.mapper.BeerDataMapper
import com.gabriel.domain.beer.model.Beer
import com.gabriel.domain.beer.repository.GetBeersByIdRepository
import com.gabriel.strategy.resource.ResourceState

class GetBeersByIdRepositoryImpl(
    private val dataStore: GetBeersByIdDataStore,
    private val mapper: BeerDataMapper
) : GetBeersByIdRepository {
    override suspend fun getBeersById(): ResourceState<List<Beer>> {
        val resourcetData = dataStore.getBeersById()
        if (resourcetData.data != null) {
            val resultData = mapper.mapToDomainNonNull(resourcetData.data!!)
            return ResourceState.Success(resultData)
        }
        return ResourceState.Error(cod = resourcetData.cod, message = resourcetData.message)
    }
}
