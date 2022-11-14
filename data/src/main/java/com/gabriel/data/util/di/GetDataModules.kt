package com.gabriel.data.util.di

import com.gabriel.data.beer.dataStore.*
import com.gabriel.data.beer.dataStoreImpl.*
import com.gabriel.data.beer.mapper.BeerDataMapper
import com.gabriel.data.beer.repository.*
import com.gabriel.data.usuario.dataStore.AutenticaUsuarioDataStore
import com.gabriel.data.usuario.dataStore.CadastraUsuarioDataStore
import com.gabriel.data.usuario.dataStore.UpdateProfileDataStore
import com.gabriel.data.usuario.dataStoreImpl.AutenticaUsuarioDataStoreImpl
import com.gabriel.data.usuario.dataStoreImpl.CadastraUsuarioDataStoreImpl
import com.gabriel.data.usuario.dataStoreImpl.UpdateProfileDataStoreImpl
import com.gabriel.data.usuario.mapper.UsuarioDataMapper
import com.gabriel.data.usuario.repository.AutenticaUsuarioRepositoryImpl
import com.gabriel.data.usuario.repository.CadastraUsuarioRepositoryImpl
import com.gabriel.data.usuario.repository.UpdateProfileRepositoryImpl
import com.gabriel.domain.beer.repository.*
import com.gabriel.domain.usuario.repository.AutenticaUsuarioRepository
import com.gabriel.domain.usuario.repository.CadastraUsuarioRepository
import com.gabriel.domain.usuario.repository.UpdateProfileRepository
import org.koin.dsl.module

fun getDataModules() = module {
    // region mapper
    factory { UsuarioDataMapper() }
    factory { BeerDataMapper() }
    // endregion

    // region data store
    factory<CadastraUsuarioDataStore> {
        CadastraUsuarioDataStoreImpl(dataSource = get())
    }
    factory<AutenticaUsuarioDataStore> {
        AutenticaUsuarioDataStoreImpl(dataSource = get())
    }
    factory<UpdateProfileDataStore> {
        UpdateProfileDataStoreImpl(dataSource = get())
    }
    factory<GetAllBeersDataStore> {
        GetAllBeersDataStoreImpl(dataSource = get())
    }
    factory<GetBeersFavDataStore> {
        GetBeersFavDataStoreImpl(dataSource = get())
    }
    factory<SaveBeerDataStore> {
        SaveBeerDataStoreImpl(dataSource = get())
    }
    factory<VerifyIfExistsDataStore> {
        VerifyIfExistsDataStoreImpl(dataSource = get())
    }
    factory<DeleteBeerDataStore> {
        DeleteBeerDataStoreImpl(dataSource = get())
    }
    // endregion

    // region repository
    factory<CadastraUsuarioRepository> {
        CadastraUsuarioRepositoryImpl(
            dataStore = get(),
            mapper = get()
        )
    }
    factory<AutenticaUsuarioRepository> {
        AutenticaUsuarioRepositoryImpl(
            dataStore = get(),
            mapper = get()
        )
    }
    factory<UpdateProfileRepository> {
        UpdateProfileRepositoryImpl(
            dataStore = get(),
            mapper = get()
        )
    }
    factory<GetAllBeersRepository> {
        GetAllBeersRepositoryImpl(
            dataStore = get(),
            mapper = get()
        )
    }
    factory<GetBeersFavRepository> {
        GetBeersFavRepositoryImpl(
            dataStore = get(),
            mapper = get()
        )
    }
    factory<SaveBeerRepository> {
        SaveBeerRepositoryImpl(
            dataStore = get(),
            mapper = get()
        )
    }
    factory<VerifyIfExistsRepository> {
        VerifyIfExistsRepositoryImpl(
            dataStore = get()
        )
    }
    factory<DeleteBeerRepository> {
        DeleteBeerRepositoryImpl(
            dataStore = get()
        )
    }
    // enregion
}