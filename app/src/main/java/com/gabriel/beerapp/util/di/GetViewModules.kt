package com.gabriel.beerapp.util.di

import com.gabriel.beerapp.beer.mapper.BeerViewMapper
import com.gabriel.beerapp.ui.view.beers.BeersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun getViewModules() = module {
    // region mappers
    factory { BeerViewMapper() }
    // endregion

    // region view model
    viewModel {
        BeersViewModel(
            mapper = get(),
            getAllBeersUseCase = get()
        )
    }
    // endregion
}