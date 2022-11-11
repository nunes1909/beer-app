package com.gabriel.remote.util.di

import com.gabriel.data.beer.dataSource.GetAllBeersDataSource
import com.gabriel.data.beer.dataSource.GetSingleBeerDataSource
import com.gabriel.remote.beer.dataSource.GetAllBeersDataSourceImpl
import com.gabriel.remote.beer.dataSource.GetSingleBeerDataSourceImpl
import com.gabriel.remote.beer.mapper.BeerRemoteMapper
import com.gabriel.remote.beer.service.GetAllBeersService
import com.gabriel.remote.beer.service.GetSingleBeerService
import com.gabriel.remote.retrofit.BeerRetrofit
import com.gabriel.remote.usuario.mapper.UsuarioRemoteMapper
import org.koin.dsl.module
import retrofit2.Retrofit

fun getRemoteModules() = module {
    // region retrofit
    single {
        BeerRetrofit().getOkHttpClient()
    }
    single<Retrofit> {
        BeerRetrofit().getRetrofit(client = get())
    }
    single<GetAllBeersService> {
        BeerRetrofit().getAllBeersService(retrofit = get())
    }
    single<GetSingleBeerService> {
        BeerRetrofit().getSingleBeerService(retrofit = get())
    }
    // endregion

    // region mapper
    factory { UsuarioRemoteMapper() }
    factory { BeerRemoteMapper() }
    // endregion

    // region data source
    factory<GetAllBeersDataSource> {
        GetAllBeersDataSourceImpl(
            service = get(),
            mapper = get()
        )
    }
    factory<GetSingleBeerDataSource> {
        GetSingleBeerDataSourceImpl(
            service = get(),
            mapper = get()
        )
    }
    // endregion
}