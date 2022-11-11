package com.gabriel.remote.retrofit

import com.gabriel.remote.beer.service.GetAllBeersService
import com.gabriel.remote.beer.service.GetSingleBeerService
import com.gabriel.domain.util.constants.ConstantsUtil.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BeerRetrofit {
    // region retrofit
    fun getRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
    // endregion

    // region okhttp
    fun getOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient().newBuilder()
            .addInterceptor(loggingInterceptor)
            .build()
    }
    // endregion

    // region service
    fun getAllBeersService(retrofit: Retrofit): GetAllBeersService {
        return retrofit.create(GetAllBeersService::class.java)
    }

    fun getSingleBeerService(retrofit: Retrofit): GetSingleBeerService {
        return retrofit.create(GetSingleBeerService::class.java)
    }
    // endregion
}