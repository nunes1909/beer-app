package com.gabriel.domain.beer.useCase

import com.gabriel.domain.beer.model.Beer
import com.gabriel.strategy.resource.ResourceState

interface GetAllBeersUseCase {
    suspend fun getAll(query: String?): ResourceState<List<Beer>>
}
