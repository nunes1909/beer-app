package com.gabriel.data.usuario.dataSource

import com.gabriel.data.usuario.model.UsuarioData

interface UpdateProfileDataSource {
    suspend fun updateProfile(usuario: UsuarioData)
}

