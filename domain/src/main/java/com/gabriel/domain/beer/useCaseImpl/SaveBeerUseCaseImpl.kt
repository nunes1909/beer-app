package com.gabriel.domain.beer.useCaseImpl

import com.gabriel.domain.beer.model.Beer
import com.gabriel.domain.beer.repository.SaveBeerRepository
import com.gabriel.domain.beer.useCase.SaveBeerUseCase

class SaveBeerUseCaseImpl(private val repository: SaveBeerRepository) : SaveBeerUseCase {
    override suspend fun saveBeer(beer: Beer) {
        return repository.saveBeer(beer = beer)
    }
}
