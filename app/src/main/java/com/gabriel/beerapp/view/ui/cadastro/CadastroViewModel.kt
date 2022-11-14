package com.gabriel.beerapp.view.ui.cadastro

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gabriel.beerapp.usuario.mapper.UsuarioViewMapper
import com.gabriel.beerapp.usuario.model.UsuarioView
import com.gabriel.domain.usuario.useCase.CadastraUsuarioUseCase
import com.gabriel.strategy.resource.ResourceState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CadastroViewModel(
    private val mapper: UsuarioViewMapper,
    private val cadastraUsuarioUseCase: CadastraUsuarioUseCase
) : ViewModel() {

    private val _cadastra = MutableStateFlow<ResourceState<Boolean>>(ResourceState.Empty())
    val cadastra: StateFlow<ResourceState<Boolean>> = _cadastra

    fun cadastraUsuario(usuarioView: UsuarioView) = viewModelScope.launch {
        val usuario = mapper.mapToDomain(usuarioView)
        _cadastra.value = cadastraUsuarioUseCase.cadastraUsuario(usuario)
    }
}
