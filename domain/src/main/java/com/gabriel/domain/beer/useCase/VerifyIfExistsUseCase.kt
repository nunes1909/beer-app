package com.gabriel.domain.beer.useCase

interface VerifyIfExistsUseCase {
    suspend fun verifyIfExists(beerId: Int): Boolean
}
