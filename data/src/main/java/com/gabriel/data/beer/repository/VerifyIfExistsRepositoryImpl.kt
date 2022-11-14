package com.gabriel.data.beer.repository

import com.gabriel.data.beer.dataStore.VerifyIfExistsDataStore
import com.gabriel.domain.beer.repository.VerifyIfExistsRepository

class VerifyIfExistsRepositoryImpl(private val dataStore: VerifyIfExistsDataStore) :
    VerifyIfExistsRepository {
    override suspend fun verifyIfExists(beerId: Int): Boolean {
        return dataStore.verifyIfExists(beerId)
    }
}
