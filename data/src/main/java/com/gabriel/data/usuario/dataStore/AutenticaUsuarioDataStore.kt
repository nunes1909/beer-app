package com.gabriel.data.usuario.dataStore

import com.gabriel.data.usuario.model.UsuarioData

interface AutenticaUsuarioDataStore {
    suspend fun autenticaUsuario(usuario: UsuarioData): Boolean
}