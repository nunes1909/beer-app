package com.gabriel.domain.beer.repository

interface DeleteBeerRepository {
    suspend fun deleteBeer(beerId: Int)
}
