package com.gabriel.data.beer.dataStoreImpl

import com.gabriel.data.beer.dataSource.VerifyIfExistsDataSource
import com.gabriel.data.beer.dataStore.VerifyIfExistsDataStore

class VerifyIfExistsDataStoreImpl(private val dataSource: VerifyIfExistsDataSource) :
    VerifyIfExistsDataStore {
    override suspend fun verifyIfExists(beerId: Int): Boolean {
        return dataSource.verifyIfExists(beerId)
    }
}
