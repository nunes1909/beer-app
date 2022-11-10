package com.gabriel.remote.beer.dataSource

import com.gabriel.data.beer.dataSource.GetAllBeersDataSource
import com.gabriel.data.beer.model.BeerData
import com.gabriel.remote.beer.mapper.BeerRemoteMapper
import com.gabriel.remote.beer.model.BeerRemote
import com.gabriel.remote.beer.service.GetAllBeersService
import retrofit2.Response
import java.io.IOException

class GetAllBeersDataSourceImpl(
    private val service: GetAllBeersService,
    private val mapper: BeerRemoteMapper
) : GetAllBeersDataSource {
    override suspend fun getAll(): List<BeerData> {
        return try {
            val response = service.getAll()
            validateResponse(response)
        } catch (t: Throwable) {
            when (t) {
                is IOException -> {
                    listOf()
                }
                else -> {
                    listOf()
                }
            }
        }
    }



    private fun validateResponse(response: Response<List<BeerRemote>>): List<BeerData> {
        if (response.isSuccessful) {
            response.body()?.let { values ->
                return mapper.mapToDataNonNull(values)
            }
        }
        return listOf()
    }
}
