package com.gabriel.beerapp.util.di

import com.gabriel.beerapp.beer.mapper.BeerViewMapper
import com.gabriel.beerapp.ui.view.beers.BeersViewModel
import com.gabriel.beerapp.ui.view.cadastro.CadastroViewModel
import com.gabriel.beerapp.ui.view.detalhes.DetalhesViewModel
import com.gabriel.beerapp.ui.view.login.LoginViewModel
import com.gabriel.beerapp.usuario.mapper.UsuarioViewMapper
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun getViewModules() = module {
    // region mappers
    factory { BeerViewMapper() }
    factory { UsuarioViewMapper() }
    // endregion

    // region view model
    viewModel {
        BeersViewModel(
            mapper = get(),
            getAllBeersUseCase = get(),
        )
    }
    viewModel {
        DetalhesViewModel(
            mapper = get(),
            getAllBeersUseCase = get(),
            getBeersByIdUseCase = get(),
            saveBeerUseCase = get()
        )
    }
    viewModel {
        CadastroViewModel(
            mapper = get(),
            cadastraUsuarioUseCase = get()
        )
    }
    viewModel {
        LoginViewModel(
            mapper = get(),
            autenticaUsuarioUseCase = get()
        )
    }
    // endregion
}