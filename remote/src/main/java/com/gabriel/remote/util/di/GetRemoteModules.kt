package com.gabriel.remote.util.di

import com.gabriel.data.beer.dataSource.GetAllBeersDataSource
import com.gabriel.data.beer.dataSource.GetBeersFavDataSource
import com.gabriel.data.beer.dataSource.SaveBeerRemoteDataSource
import com.gabriel.data.beer.dataSource.VerifyIfExistsDataSource
import com.gabriel.data.usuario.dataSource.AutenticaUsuarioDataSource
import com.gabriel.data.usuario.dataSource.CadastraUsuarioDataSource
import com.gabriel.remote.beer.dataSource.GetAllBeersDataSourceImpl
import com.gabriel.remote.beer.dataSource.GetBeersFavDataSourceImpl
import com.gabriel.remote.beer.dataSource.SaveBeerRemoteDataSourceImpl
import com.gabriel.remote.beer.dataSource.VerifyIfExistsDataSourceImpl
import com.gabriel.remote.beer.mapper.BeerRemoteMapper
import com.gabriel.remote.beer.service.GetAllBeersService
import com.gabriel.remote.beer.service.GetBeersByIdService
import com.gabriel.remote.retrofit.BeerRetrofit
import com.gabriel.remote.usuario.dataSource.AutenticaUsuarioDataSourceImpl
import com.gabriel.remote.usuario.dataSource.CadastraUsuarioDataSourceImpl
import com.gabriel.remote.usuario.mapper.UsuarioRemoteMapper
import com.gabriel.remote.usuario.validate.ValidaUsuarioFirebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import org.koin.dsl.module
import retrofit2.Retrofit

fun getRemoteModules() = module {
    // region firebase
    single<FirebaseAuth> { Firebase.auth }
    single<FirebaseFirestore> { Firebase.firestore }
    // endregion

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
    single<GetBeersByIdService> {
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
    factory<GetBeersFavDataSource> {
        GetBeersFavDataSourceImpl(
            firestore = get(),
            firebaseAuth = get(),
            mapper = get()
        )
    }
    factory<CadastraUsuarioDataSource> {
        CadastraUsuarioDataSourceImpl(
            firebaseAuth = get(),
            validaUser = ValidaUsuarioFirebase()
        )
    }
    factory<AutenticaUsuarioDataSource> {
        AutenticaUsuarioDataSourceImpl(
            firebaseAuth = get(),
            validaUser = ValidaUsuarioFirebase()
        )
    }
    factory<SaveBeerRemoteDataSource> {
        SaveBeerRemoteDataSourceImpl(
            firestore = get(),
            firebaseAuth = get(),
            mapper = get()
        )
    }
    factory<VerifyIfExistsDataSource> {
        VerifyIfExistsDataSourceImpl(
            firestore = get(),
            firebaseAuth = get()
        )
    }
    // endregion
}