package com.gabriel.remote.usuario.validate

import com.gabriel.strategy.resource.ResourceState
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.*
import kotlinx.coroutines.delay

class ValidaUsuarioFirebase {
    suspend fun validaTask(task: Task<AuthResult>, auth: Boolean): ResourceState<Boolean> {
        delay(timeMillis = 2000)
        return if (task.isComplete && task.isSuccessful && task.exception == null) {
            ResourceState.Default(data = true)
        } else {
            val mensagem = if (auth) {
                catchErrorAuth(task.exception)
            } else {
                catchErrorCadastro(task.exception)
            }
            ResourceState.Default(data = false, message = mensagem)
        }
    }

    private fun catchErrorCadastro(exception: Exception?): String = when (exception) {
        is FirebaseAuthWeakPasswordException -> "A senha precisa ter pelo menos 6 dígitos."
        is FirebaseAuthInvalidCredentialsException -> "E-mail ou senha inválido."
        is FirebaseAuthUserCollisionException -> "E-mail já cadastrado."
        else -> "Erro desconhecido -> ${exception?.message}"
    }

    private fun catchErrorAuth(exception: Exception?): String = when (exception) {
        is FirebaseAuthInvalidUserException,
        is FirebaseAuthInvalidCredentialsException -> "E-mail ou senha incorretos"
        else -> "Erro desconhecido -> ${exception?.message}"
    }
}
