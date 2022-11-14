package com.gabriel.domain.beer.useCaseImpl

import com.gabriel.domain.beer.model.Beer
import com.gabriel.domain.beer.repository.GetBeersFavRepository
import com.gabriel.domain.beer.useCase.GetBeersFavUseCase
import com.gabriel.strategy.resource.ResourceState

class GetBeersFavUseCaseImpl(private val repository: GetBeersFavRepository) :
    GetBeersFavUseCase {
    override suspend fun getBeersFav(): ResourceState<List<Beer>> {
        return repository.getBeersFav()
    }
}
