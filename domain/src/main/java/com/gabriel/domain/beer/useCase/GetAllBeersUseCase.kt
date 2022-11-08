package com.gabriel.domain.beer.useCase

import com.gabriel.domain.beer.model.Beer

interface GetAllBeersUseCase {
    suspend fun getAll(): List<Beer>
}
