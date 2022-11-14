package com.gabriel.beerapp.view.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gabriel.beerapp.usuario.mapper.UsuarioViewMapper
import com.gabriel.beerapp.usuario.model.UsuarioView
import com.gabriel.domain.usuario.useCase.AutenticaUsuarioUseCase
import com.gabriel.strategy.resource.ResourceState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val mapper: UsuarioViewMapper,
    private val autenticaUsuarioUseCase: AutenticaUsuarioUseCase
) : ViewModel() {

    private val _autentica = MutableStateFlow<ResourceState<Boolean>>(ResourceState.Empty())
    val autentica: StateFlow<ResourceState<Boolean>> = _autentica

    fun autenticaUsuario(usuarioView: UsuarioView) = viewModelScope.launch {
        val usuario = mapper.mapToDomain(usuarioView)
        _autentica.value = autenticaUsuarioUseCase.autenticaUsuario(usuario)
    }
}
