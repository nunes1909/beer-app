package com.gabriel.domain.beer.useCaseImpl

import com.gabriel.domain.beer.model.Beer
import com.gabriel.domain.beer.repository.DeleteBeerRepository
import com.gabriel.domain.beer.useCase.DeleteBeerUseCase
import com.gabriel.strategy.resource.ResourceState

class DeleteBeerUseCaseImpl(private val repository: DeleteBeerRepository) : DeleteBeerUseCase {
    override suspend fun deleteBeer(beer: Beer) {
        return repository.deleteBeer(beer = beer)
        ResourceState.Success(true)
    }
}
