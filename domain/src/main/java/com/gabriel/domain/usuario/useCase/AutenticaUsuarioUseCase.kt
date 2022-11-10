package com.gabriel.domain.usuario.useCase

import com.gabriel.domain.usuario.model.Usuario

interface AutenticaUsuarioUseCase {
    suspend fun autenticaUsuario(usuario: Usuario): Boolean
}
