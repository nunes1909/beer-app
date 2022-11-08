package com.gabriel.domain.beer.useCase

import com.gabriel.domain.beer.model.Beer

interface GetStoredBeersUseCase {
    suspend fun getAll(): List<Beer>
}
