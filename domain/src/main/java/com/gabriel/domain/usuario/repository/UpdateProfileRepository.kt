package com.gabriel.domain.usuario.repository

import com.gabriel.domain.usuario.model.Usuario

interface UpdateProfileRepository {
    suspend fun updateProfile(usuario: Usuario)
}
