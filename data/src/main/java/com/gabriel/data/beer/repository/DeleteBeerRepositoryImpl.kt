package com.gabriel.data.beer.repository

import com.gabriel.data.beer.dataStore.DeleteBeerDataStore
import com.gabriel.domain.beer.repository.DeleteBeerRepository

class DeleteBeerRepositoryImpl(private val dataStore: DeleteBeerDataStore) : DeleteBeerRepository {
    override suspend fun deleteBeer(beerId: Int) {
        return dataStore.deleteBeer(beerId)
    }
}
