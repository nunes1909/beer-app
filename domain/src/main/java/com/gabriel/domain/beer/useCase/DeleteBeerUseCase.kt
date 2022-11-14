package com.gabriel.domain.beer.useCase

interface DeleteBeerUseCase {
    suspend fun deleteBeer(beerId: Int)
}
