package com.gabriel.domain.beer.useCaseImpl

import com.gabriel.domain.beer.model.Beer
import com.gabriel.domain.beer.repository.GetBeersByIdRepository
import com.gabriel.domain.beer.useCase.GetBeersByIdUseCase
import com.gabriel.strategy.resource.ResourceState

class GetBeersByIdUseCaseImpl(private val repository: GetBeersByIdRepository) :
    GetBeersByIdUseCase {
    override suspend fun getBeersById(): ResourceState<List<Beer>> {
        return repository.getBeersById()
    }
}
