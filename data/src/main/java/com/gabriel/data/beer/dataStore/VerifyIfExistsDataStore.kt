package com.gabriel.data.beer.dataStore

interface VerifyIfExistsDataStore {
    suspend fun verifyIfExists(beerId: Int): Boolean
}
