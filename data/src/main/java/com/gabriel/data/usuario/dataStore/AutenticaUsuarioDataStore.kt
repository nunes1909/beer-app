package com.gabriel.data.usuario.dataStore

import com.gabriel.data.usuario.model.UsuarioData
import com.gabriel.domain.util.resource.ResourceState

interface AutenticaUsuarioDataStore {
    suspend fun autenticaUsuario(usuario: UsuarioData): ResourceState<Boolean>
}