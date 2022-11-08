package com.gabriel.domain.beer.useCaseImpl

import com.gabriel.domain.beer.model.Beer
import com.gabriel.domain.beer.repository.DeleteBeerRepository
import com.gabriel.domain.beer.useCase.DeleteBeerUseCase

class DeleteBeerUseCaseImpl(private val repository: DeleteBeerRepository) : DeleteBeerUseCase {
    override suspend fun deleteBeer(beer: Beer) {
        return repository.deleteBeer(beer = beer)
    }
}
