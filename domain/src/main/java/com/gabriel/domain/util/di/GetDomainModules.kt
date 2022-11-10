package com.gabriel.domain.util.di

import com.gabriel.domain.beer.useCase.*
import com.gabriel.domain.beer.useCaseImpl.*
import com.gabriel.domain.usuario.useCase.AutenticaUsuarioUseCase
import com.gabriel.domain.usuario.useCase.CadastraUsuarioUseCase
import com.gabriel.domain.usuario.useCaseImpl.AutenticaUsuarioUseCaseImpl
import com.gabriel.domain.usuario.useCaseImpl.CadastraUsuarioUseCaseImpl
import org.koin.dsl.module

fun getDomainModules() = module {
    // region use case
    factory<AutenticaUsuarioUseCase> { AutenticaUsuarioUseCaseImpl(repository = get()) }
    factory<CadastraUsuarioUseCase> { CadastraUsuarioUseCaseImpl(repository = get()) }
    factory<GetAllBeersUseCase> { GetAllBeersUseCaseImpl(repository = get()) }
    factory<GetSingleBeerUseCase> { GetSingleBeerUseCaseImpl(repository = get()) }
    factory<SaveBeerUseCase> { SaveBeerUseCaseImpl(repository = get()) }
    factory<GetStoredBeersUseCase> { GetStoredBeersUseCaseImpl(repository = get()) }
    factory<DeleteBeerUseCase> { DeleteBeerUseCaseImpl(repository = get()) }
    // endregion
}