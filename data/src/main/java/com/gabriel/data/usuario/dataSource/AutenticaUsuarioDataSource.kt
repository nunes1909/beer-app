package com.gabriel.data.usuario.dataSource

import com.gabriel.data.usuario.model.UsuarioData

interface AutenticaUsuarioDataSource {
    suspend fun autenticaUsuario(usuario: UsuarioData): Boolean
}