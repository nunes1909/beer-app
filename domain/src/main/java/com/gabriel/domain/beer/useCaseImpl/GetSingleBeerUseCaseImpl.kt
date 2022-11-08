package com.gabriel.domain.beer.useCaseImpl

import com.gabriel.domain.beer.model.Beer
import com.gabriel.domain.beer.repository.GetSingleBeerRepository
import com.gabriel.domain.beer.useCase.GetSingleBeerUseCase

class GetSingleBeerUseCaseImpl(private val repository: GetSingleBeerRepository) :
    GetSingleBeerUseCase {
    override suspend fun getSingleBeer(beerId: Int): Beer {
        return repository.getSingleBeer(beerId = beerId)
    }
}
