package com.gabriel.domain.usuario.useCase

import com.gabriel.domain.usuario.model.Usuario

interface UpdateProfileUseCase {
    suspend fun updateProfile(usuario: Usuario)
}
