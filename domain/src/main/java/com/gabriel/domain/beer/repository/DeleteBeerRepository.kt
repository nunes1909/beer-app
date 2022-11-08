package com.gabriel.domain.beer.repository

import com.gabriel.domain.beer.model.Beer

interface DeleteBeerRepository {
    suspend fun deleteBeer(beer: Beer)
}
