package com.gabriel.domain.beer.repository

import com.gabriel.domain.beer.model.Beer
import com.gabriel.strategy.resource.ResourceState

interface GetAllBeersRepository {
    suspend fun getAll(query: String?): ResourceState<List<Beer>>
}
