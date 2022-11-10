package com.gabriel.data.usuario.dataStore

import com.gabriel.data.usuario.model.UsuarioData

interface CadastraUsuarioDataStore {
    suspend fun cadastraUsuario(usuario: UsuarioData): Boolean
}
