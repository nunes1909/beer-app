package com.gabriel.data.usuario.dataStoreImpl

import com.gabriel.data.usuario.dataSource.CadastraUsuarioDataSource
import com.gabriel.data.usuario.dataStore.CadastraUsuarioDataStore
import com.gabriel.data.usuario.model.UsuarioData

class CadastraUsuarioDataStoreImpl(private val dataSource: CadastraUsuarioDataSource) :
    CadastraUsuarioDataStore {
    override suspend fun cadastraUsuario(usuario: UsuarioData): Boolean {
        return dataSource.cadastraUsuario(usuario)
    }
}
