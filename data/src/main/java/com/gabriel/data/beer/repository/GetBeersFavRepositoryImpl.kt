package com.gabriel.data.beer.repository

import com.gabriel.data.beer.dataStore.GetBeersFavDataStore
import com.gabriel.data.beer.mapper.BeerDataMapper
import com.gabriel.domain.beer.model.Beer
import com.gabriel.domain.beer.repository.GetBeersFavRepository
import com.gabriel.strategy.resource.ResourceState

class GetBeersFavRepositoryImpl(
    private val dataStore: GetBeersFavDataStore,
    private val mapper: BeerDataMapper
) : GetBeersFavRepository {
    override suspend fun getBeersFav(): ResourceState<List<Beer>> {
        val resourcetData = dataStore.getBeersFav()
        if (resourcetData.data != null) {
            val resultData = mapper.mapToDomainNonNull(resourcetData.data!!)
            return ResourceState.Success(resultData)
        }
        return ResourceState.Error(cod = resourcetData.cod, message = resourcetData.message)
    }
}
