package com.gabriel.beerapp.util.di

import com.gabriel.beerapp.beer.mapper.BeerViewMapper
import com.gabriel.beerapp.view.ui.beers.BeersViewModel
import com.gabriel.beerapp.view.ui.cadastro.CadastroViewModel
import com.gabriel.beerapp.view.ui.detalhes.DetalhesViewModel
import com.gabriel.beerapp.view.ui.favoritos.FavoritosViewModel
import com.gabriel.beerapp.view.ui.login.LoginViewModel
import com.gabriel.beerapp.usuario.mapper.UsuarioViewMapper
import com.gabriel.beerapp.view.ui.conta.ContaViewModel
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
            verifyIfExistsUseCase = get(),
            saveBeerUseCase = get(),
            deleteBeerUseCase = get()
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
    viewModel {
        ContaViewModel(
            mapper = get(),
            updateProfileUseCase = get()
        )
    }
    viewModel {
        FavoritosViewModel(
            mapper = get(),
            getBeersFavUseCase = get(),
            deleteBeerUseCase = get()
        )
    }
    // endregion
}