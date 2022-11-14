package com.gabriel.data.beer.dataSource

interface VerifyIfExistsDataSource {
    suspend fun verifyIfExists(beerId: Int): Boolean
}
