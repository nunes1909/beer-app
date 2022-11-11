package com.gabriel.domain.beer.useCaseImpl

import com.gabriel.domain.beer.model.Beer
import com.gabriel.domain.beer.repository.GetAllBeersRepository
import com.gabriel.domain.beer.useCase.GetAllBeersUseCase
import com.gabriel.domain.util.resource.ResourceState

class GetAllBeersUseCaseImpl(private val repository: GetAllBeersRepository) : GetAllBeersUseCase {
    override suspend fun getAll(query: String?): ResourceState<List<Beer>> {
        return repository.getAll(query)
    }
}
