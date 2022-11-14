package com.gabriel.domain.beer.useCaseImpl

import com.gabriel.domain.beer.repository.DeleteBeerRepository
import com.gabriel.domain.beer.useCase.DeleteBeerUseCase

class DeleteBeerUseCaseImpl(private val repository: DeleteBeerRepository) : DeleteBeerUseCase {
    override suspend fun deleteBeer(beerId: Int) {
        return repository.deleteBeer(beerId)
    }
}
