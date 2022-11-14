package com.gabriel.domain.beer.repository

interface VerifyIfExistsRepository {
    suspend fun verifyIfExists(beerId: Int): Boolean
}
