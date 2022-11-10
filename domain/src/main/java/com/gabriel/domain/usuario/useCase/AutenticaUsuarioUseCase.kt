package com.gabriel.domain.usuario.useCase

import com.gabriel.domain.usuario.model.Usuario

interface CadastraUsuarioUseCase {
    suspend fun cadastraUsuario(usuario: Usuario): Boolean
}
