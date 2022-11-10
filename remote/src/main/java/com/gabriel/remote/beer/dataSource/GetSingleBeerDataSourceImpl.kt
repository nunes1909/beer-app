package com.gabriel.remote.beer.dataSource

import android.util.Log
import com.gabriel.data.beer.dataSource.GetSingleBeerDataSource
import com.gabriel.data.beer.model.BeerData
import com.gabriel.domain.util.resource.ResourceState
import com.gabriel.remote.beer.mapper.BeerRemoteMapper
import com.gabriel.remote.beer.model.BeerRemote
import com.gabriel.remote.beer.service.GetSingleBeerService
import com.gabriel.strategy.constants.ConstantsUtil.MSG_GET_SINGLE_BEERS_DS
import com.gabriel.strategy.constants.ConstantsUtil.TAG_GET_SINGLE_BEERS_DS
import retrofit2.Response
import java.io.IOException

class GetSingleBeerDataSourceImpl(
    private val service: GetSingleBeerService,
    private val mapper: BeerRemoteMapper
) : GetSingleBeerDataSource {
    override suspend fun getSingleBeer(beerId: Int): ResourceState<BeerData> {
        return try {
            val response = service.getSingleBeer(beerId)
            validateResponse(response)
        } catch (t: Throwable) {
            when (t) {
                is IOException -> {
                    Log.e(TAG_GET_SINGLE_BEERS_DS, MSG_GET_SINGLE_BEERS_DS, t)
                    ResourceState.Error(message = "Erro de conexão.")
                }
                else -> {
                    Log.e(TAG_GET_SINGLE_BEERS_DS, MSG_GET_SINGLE_BEERS_DS, t)
                    ResourceState.Error(message = "Erro na conversão/parse dos dados")
                }
            }
        }
    }

    private fun validateResponse(response: Response<BeerRemote>): ResourceState<BeerData> {
        if (response.isSuccessful) {
            response.body()?.let { values ->
                val resultData = mapper.mapToData(values)
                return ResourceState.Success(resultData)
            }
        }
        return ResourceState.Error(cod = response.code(), message = response.message())
    }
}
