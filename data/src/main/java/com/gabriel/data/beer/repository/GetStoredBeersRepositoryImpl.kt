package com.gabriel.data.beer.repository

import com.gabriel.data.beer.dataStore.GetStoredBeersDataStore
import com.gabriel.data.beer.mapper.BeerDataMapper
import com.gabriel.domain.beer.model.Beer
import com.gabriel.domain.beer.repository.GetStoredBeersRepository

class GetStoredBeersRepositoryImpl(
    private val dataStore: GetStoredBeersDataStore,
    private val mapper: BeerDataMapper
) : GetStoredBeersRepository {
    override suspend fun getAll(): List<Beer> {
        val resultData = dataStore.getAll()
        return mapper.mapToDomainNonNull(resultData)
    }
}
