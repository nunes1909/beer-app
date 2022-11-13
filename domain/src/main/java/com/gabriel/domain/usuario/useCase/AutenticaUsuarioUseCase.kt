package com.gabriel.domain.usuario.useCase

import com.gabriel.domain.usuario.model.Usuario
import com.gabriel.strategy.resource.ResourceState

interface AutenticaUsuarioUseCase {
    suspend fun autenticaUsuario(usuario: Usuario): ResourceState<Boolean>
}
