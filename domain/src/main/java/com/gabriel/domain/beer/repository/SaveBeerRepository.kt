package com.gabriel.domain.beer.repository

import com.gabriel.domain.beer.model.Beer

interface SaveBeerRepository {
    suspend fun saveBeer(beer: Beer)
}
