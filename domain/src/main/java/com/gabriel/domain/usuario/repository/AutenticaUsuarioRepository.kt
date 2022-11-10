package com.gabriel.domain.usuario.repository

import com.gabriel.domain.usuario.model.Usuario
import com.gabriel.domain.util.resource.ResourceState

interface AutenticaUsuarioRepository {
    suspend fun autenticaUsuario(usuario: Usuario): ResourceState<Boolean>
}
