package com.gabriel.domain.usuario.repository

import com.gabriel.domain.usuario.model.Usuario

interface CadastraUsuarioRepository {
    suspend fun cadastraUsuario(usuario: Usuario): Boolean
}