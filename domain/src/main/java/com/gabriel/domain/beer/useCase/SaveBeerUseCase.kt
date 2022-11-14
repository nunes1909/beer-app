package com.gabriel.domain.beer.useCase

import com.gabriel.domain.beer.model.Beer

interface SaveBeerUseCase {
    suspend fun saveBeer(beer: Beer)
}
