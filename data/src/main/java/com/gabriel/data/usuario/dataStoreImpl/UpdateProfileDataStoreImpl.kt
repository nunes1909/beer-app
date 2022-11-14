package com.gabriel.data.usuario.dataStoreImpl

import com.gabriel.data.usuario.dataSource.UpdateProfileDataSource
import com.gabriel.data.usuario.dataStore.UpdateProfileDataStore
import com.gabriel.data.usuario.model.UsuarioData

class UpdateProfileDataStoreImpl(private val dataSource: UpdateProfileDataSource) :
    UpdateProfileDataStore {
    override suspend fun updateProfile(usuario: UsuarioData) {
        return dataSource.updateProfile(usuario)
    }
}
