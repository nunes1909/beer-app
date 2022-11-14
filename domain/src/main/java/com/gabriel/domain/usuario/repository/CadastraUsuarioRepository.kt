package com.gabriel.domain.usuario.repository

import com.gabriel.domain.usuario.model.Usuario
import com.gabriel.strategy.resource.ResourceState

interface CadastraUsuarioRepository {
    suspend fun cadastraUsuario(usuario: Usuario): ResourceState<Boolean>
}
