package com.gabriel.domain.beer.repository

import com.gabriel.domain.beer.model.Beer

interface GetAllBeersRepository {
    suspend fun getAll(): List<Beer>
}
