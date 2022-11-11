package com.gabriel.domain.beer.useCase

import com.gabriel.domain.beer.model.Beer
import com.gabriel.domain.util.resource.ResourceState

interface GetAllBeersUseCase {
    suspend fun getAll(query: String?): ResourceState<List<Beer>>
}
