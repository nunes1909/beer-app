package com.gabriel.data.usuario.repository

import com.gabriel.data.usuario.dataStore.UpdateProfileDataStore
import com.gabriel.data.usuario.mapper.UsuarioDataMapper
import com.gabriel.domain.usuario.model.Usuario
import com.gabriel.domain.usuario.repository.UpdateProfileRepository

class UpdateProfileRepositoryImpl(
    private val dataStore: UpdateProfileDataStore,
    private val mapper: UsuarioDataMapper
) : UpdateProfileRepository {
    override suspend fun updateProfile(usuario: Usuario) {
        val usuarioData = mapper.mapToData(usuario)
        return dataStore.updateProfile(usuarioData)
    }
}
