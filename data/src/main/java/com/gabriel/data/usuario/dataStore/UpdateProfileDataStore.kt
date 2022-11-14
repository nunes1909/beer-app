package com.gabriel.data.usuario.dataStore

import com.gabriel.data.usuario.model.UsuarioData

interface UpdateProfileDataStore {
    suspend fun updateProfile(usuario: UsuarioData)
}
