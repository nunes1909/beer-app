package com.gabriel.domain.beer.useCaseImpl

import com.gabriel.domain.beer.model.Beer
import com.gabriel.domain.beer.repository.GetSingleBeerRepository
import com.gabriel.domain.beer.useCase.GetSingleBeerUseCase
import com.gabriel.domain.util.resource.ResourceState

class GetSingleBeerUseCaseImpl(private val repository: GetSingleBeerRepository) :
    GetSingleBeerUseCase {
    override suspend fun getSingleBeer(beerId: Int): ResourceState<Beer> {
        return repository.getSingleBeer(beerId = beerId)
    }
}
