package com.gabriel.domain.util.di

import com.gabriel.domain.beer.useCase.*
import com.gabriel.domain.beer.useCaseImpl.*
import com.gabriel.domain.usuario.useCase.AutenticaUsuarioUseCase
import com.gabriel.domain.usuario.useCase.CadastraUsuarioUseCase
import com.gabriel.domain.usuario.useCase.UpdateProfileUseCase
import com.gabriel.domain.usuario.useCaseImpl.AutenticaUsuarioUseCaseImpl
import com.gabriel.domain.usuario.useCaseImpl.CadastraUsuarioUseCaseImpl
import com.gabriel.domain.usuario.useCaseImpl.UpdateProfileUseCaseImpl
import org.koin.dsl.module

fun getDomainModules() = module {
    // region use case
    factory<AutenticaUsuarioUseCase> { AutenticaUsuarioUseCaseImpl(repository = get()) }
    factory<CadastraUsuarioUseCase> { CadastraUsuarioUseCaseImpl(repository = get()) }
    factory<UpdateProfileUseCase> { UpdateProfileUseCaseImpl(repository = get()) }
    factory<GetAllBeersUseCase> { GetAllBeersUseCaseImpl(repository = get()) }
    factory<GetBeersFavUseCase> { GetBeersFavUseCaseImpl(repository = get()) }
    factory<SaveBeerUseCase> { SaveBeerUseCaseImpl(repository = get()) }
    factory<VerifyIfExistsUseCase> { VerifyIfExistsUseCaseImpl(repository = get()) }
    factory<DeleteBeerUseCase> { DeleteBeerUseCaseImpl(repository = get()) }
    // endregion
}