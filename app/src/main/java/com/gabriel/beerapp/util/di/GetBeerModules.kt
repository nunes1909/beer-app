package com.gabriel.beerapp.util.di

import com.gabriel.data.util.di.getDataModules
import com.gabriel.domain.util.di.getDomainModules
import com.gabriel.remote.util.di.getRemoteModules
import org.koin.core.module.Module

object GetBeerModules {
    fun getBeerAppModules(): List<Module> {
        return listOf(
            getViewModules(),
            getDomainModules(),
            getDataModules(),
            getRemoteModules()
        )
    }
}
