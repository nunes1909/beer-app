package com.gabriel.data.usuario.repository

import com.gabriel.data.usuario.dataStore.CadastraUsuarioDataStore
import com.gabriel.data.usuario.mapper.UsuarioDataMapper
import com.gabriel.domain.usuario.model.Usuario
import com.gabriel.domain.usuario.repository.CadastraUsuarioRepository

class CadastraUsuarioRepositoryImpl(
    private val dataStore: CadastraUsuarioDataStore,
    private val mapper: UsuarioDataMapper
) : CadastraUsuarioRepository {
    override suspend fun cadastraUsuario(usuario: Usuario): Boolean {
        val usuarioData = mapper.mapToData(usuario)
        return dataStore.cadastraUsuario(usuarioData)
    }
}
