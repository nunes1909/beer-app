package com.gabriel.data.usuario.dataStore

import com.gabriel.data.usuario.model.UsuarioData
import com.gabriel.strategy.resource.ResourceState

interface CadastraUsuarioDataStore {
    suspend fun cadastraUsuario(usuario: UsuarioData): ResourceState<Boolean>
}
