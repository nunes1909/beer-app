package com.gabriel.domain.usuario.useCase

import com.gabriel.domain.usuario.model.Usuario
import com.gabriel.strategy.resource.ResourceState

interface CadastraUsuarioUseCase {
    suspend fun cadastraUsuario(usuario: Usuario): ResourceState<Boolean>
}
