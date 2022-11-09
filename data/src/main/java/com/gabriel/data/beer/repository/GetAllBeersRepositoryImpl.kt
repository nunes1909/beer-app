package com.gabriel.data.beer.repository

import com.gabriel.data.beer.dataStore.GetAllBeersDataStore
import com.gabriel.data.beer.mapper.BeerDataMapper
import com.gabriel.domain.beer.model.Beer
import com.gabriel.domain.beer.repository.GetAllBeersRepository

class GetAllBeersRepositoryImpl(
    private val dataStore: GetAllBeersDataStore,
    private val mapper: BeerDataMapper
) : GetAllBeersRepository {
    override suspend fun getAll(): List<Beer> {
        val resultData = dataStore.getAll()
        return mapper.mapToDomainNonNull(resultData)
    }
}
