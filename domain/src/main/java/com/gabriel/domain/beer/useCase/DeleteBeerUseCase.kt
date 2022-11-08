package com.gabriel.domain.beer.useCase

import com.gabriel.domain.beer.model.Beer

interface DeleteBeerUseCase {
    suspend fun deleteBeer(beer: Beer)
}