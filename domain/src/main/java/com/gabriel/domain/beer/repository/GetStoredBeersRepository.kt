package com.gabriel.domain.beer.repository

import com.gabriel.domain.beer.model.Beer

interface GetStoredBeersRepository {
    suspend fun getAll(): List<Beer>
}
