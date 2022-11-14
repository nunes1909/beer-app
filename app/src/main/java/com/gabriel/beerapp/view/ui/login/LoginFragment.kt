package com.gabriel.beerapp.view.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.gabriel.beerapp.databinding.FragmentLoginBinding
import com.gabriel.beerapp.view.ui.login.validaLogin.ValidaLogin
import com.gabriel.beerapp.usuario.model.UsuarioView
import com.gabriel.beerapp.util.base.BaseFragmentOut
import com.gabriel.beerapp.util.extensions.snack
import com.gabriel.beerapp.util.extensions.toast
import com.gabriel.strategy.resource.ResourceState
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragmentOut<FragmentLoginBinding, LoginViewModel>() {

    override val viewModel: LoginViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goLogin()
        goCadastrar()
        observerAuth()
    }

    private fun goLogin() {
        binding.btnLoginLogar.setOnClickListener {
            clearErrors()
            validaCampos()
        }
    }

    private fun clearErrors() = with(binding) {
        etLoginEmail.error = null
        etLoginSenha.error = null
    }

    private fun validaCampos() = with(binding) {
        val email = etLoginEmail.text?.trim().toString()
        val senha = etLoginSenha.text?.trim().toString()

        when (val resource = ValidaLogin().validaCamposFormulario(email = email, senha = senha)) {
            is ResourceState.Success -> {
                viewModel.autenticaUsuario(UsuarioView(email = email, senha = senha))
            }
            else -> {
                snack(requireView(), resource.message!!)
            }
        }
    }

    private fun observerAuth() = lifecycleScope.launch {
        viewModel.autentica.collect { resource ->
            when (resource) {
                is ResourceState.Default -> { defineAcaoPosAuth(resource) }
                else -> {}
            }
        }
    }

    private fun defineAcaoPosAuth(resource: ResourceState<Boolean>) {
        if (resource.data!!) {
            val action = LoginFragmentDirections.acaoLoginParaBeers()
            controller.navigate(action)
        } else {
            toast(resource.message!!)
        }
    }

    private fun goCadastrar() {
        binding.btnLoginCadastrar.setOnClickListener {
            val action = LoginFragmentDirections.acaoLoginParaCadastro()
            findNavController().navigate(action)
        }
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLoginBinding =
        FragmentLoginBinding.inflate(layoutInflater, container, false)
}
