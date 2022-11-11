package com.gabriel.data.beer.repository

import com.gabriel.data.beer.dataStore.GetAllBeersDataStore
import com.gabriel.data.beer.mapper.BeerDataMapper
import com.gabriel.domain.beer.model.Beer
import com.gabriel.domain.beer.repository.GetAllBeersRepository
import com.gabriel.domain.util.resource.ResourceState

class GetAllBeersRepositoryImpl(
    private val dataStore: GetAllBeersDataStore,
    private val mapper: BeerDataMapper
) : GetAllBeersRepository {
    override suspend fun getAll(query: String?): ResourceState<List<Beer>> {
        val resourceData = dataStore.getAll(query)
        if (resourceData.data != null) {
            val resultDomain = mapper.mapToDomainNonNull(resourceData.data!!)
            return ResourceState.Success(resultDomain)
        }
        return ResourceState.Error(cod = resourceData.cod, message = resourceData.message)
    }
}
