package com.gabriel.domain.usuario.useCase

import com.gabriel.domain.usuario.model.Usuario
import com.gabriel.domain.util.resource.ResourceState

interface AutenticaUsuarioUseCase {
    suspend fun autenticaUsuario(usuario: Usuario): ResourceState<Boolean>
}
