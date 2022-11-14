package com.gabriel.domain.beer.useCaseImpl

import com.gabriel.domain.beer.repository.VerifyIfExistsRepository
import com.gabriel.domain.beer.useCase.VerifyIfExistsUseCase

class VerifyIfExistsUseCaseImpl(private val repository: VerifyIfExistsRepository) :
    VerifyIfExistsUseCase {
    override suspend fun verifyIfExists(beerId: Int): Boolean {
        return repository.verifyIfExists(beerId)
    }
}
