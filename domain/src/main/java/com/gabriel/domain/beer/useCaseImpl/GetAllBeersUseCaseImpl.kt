package com.gabriel.domain.beer.useCaseImpl

import com.gabriel.domain.beer.model.Beer
import com.gabriel.domain.beer.repository.GetAllBeersRepository
import com.gabriel.domain.beer.useCase.GetAllBeersUseCase

class GetAllBeersUseCaseImpl(private val repository: GetAllBeersRepository) : GetAllBeersUseCase {
    override suspend fun getAll(): List<Beer> {
        return repository.getAll()
    }
}
