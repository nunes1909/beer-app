package com.gabriel.domain.usuario.repository

import com.gabriel.domain.usuario.model.Usuario

interface AutenticaUsuarioRepository {
    suspend fun autenticaUsuario(usuario: Usuario): Boolean
}