package com.gabriel.beerapp.view.ui.conta

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gabriel.beerapp.beer.model.BeerView
import com.gabriel.beerapp.usuario.mapper.UsuarioViewMapper
import com.gabriel.beerapp.usuario.model.UsuarioView
import com.gabriel.domain.usuario.useCase.UpdateProfileUseCase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ContaViewModel(
    private val mapper: UsuarioViewMapper,
    private val updateProfileUseCase: UpdateProfileUseCase
) : ViewModel() {

    init {

    }

    fun updateProfile(usuarioView: UsuarioView) = viewModelScope.launch {
        val usuario = mapper.mapToDomain(usuarioView)
        updateProfileUseCase.updateProfile(usuario)
    }
}