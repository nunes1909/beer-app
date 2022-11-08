package com.gabriel.domain.beer.useCaseImpl

import com.gabriel.domain.beer.model.Beer
import com.gabriel.domain.beer.repository.GetStoredBeersRepository
import com.gabriel.domain.beer.useCase.GetStoredBeersUseCase

class GetStoredBeersUseCaseImpl(private val repository: GetStoredBeersRepository) :
    GetStoredBeersUseCase {
    override suspend fun getAll(): List<Beer> {
        return repository.getAll()
    }
}
