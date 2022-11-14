package com.gabriel.remote.usuario.dataSource

import com.gabriel.data.usuario.dataSource.UpdateProfileDataSource
import com.gabriel.data.usuario.model.UsuarioData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.ktx.userProfileChangeRequest

class UpdateProfileDataSourceImpl(private val firebaseAuth: FirebaseAuth): UpdateProfileDataSource {
    override suspend fun updateProfile(usuario: UsuarioData) {
        val usuarioAtual = firebaseAuth.currentUser!!

        val profileUpdates = userProfileChangeRequest {
            displayName = usuario.nome!!
        }

        usuarioAtual.updateProfile(profileUpdates)
        usuarioAtual.updateEmail(usuario.email!!)
    }
}
