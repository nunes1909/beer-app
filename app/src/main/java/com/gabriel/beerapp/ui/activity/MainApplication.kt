package com.gabriel.beerapp.ui.activity

import android.app.Application
import com.gabriel.beerapp.util.di.GetBeerModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(GetBeerModules.getBeerAppModules())
        }
    }
}
