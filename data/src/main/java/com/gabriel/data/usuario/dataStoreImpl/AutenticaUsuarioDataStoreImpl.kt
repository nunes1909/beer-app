package com.gabriel.data.usuario.dataStoreImpl

import com.gabriel.data.usuario.dataSource.AutenticaUsuarioDataSource
import com.gabriel.data.usuario.dataStore.AutenticaUsuarioDataStore
import com.gabriel.data.usuario.model.UsuarioData

class AutenticaUsuarioDataStoreImpl(private val dataSource: AutenticaUsuarioDataSource) :
    AutenticaUsuarioDataStore {
    override suspend fun autenticaUsuario(usuario: UsuarioData): Boolean {
        return dataSource.autenticaUsuario(usuario)
    }
}
