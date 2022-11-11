package com.gabriel.beerapp.ui.view.cadastro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.gabriel.beerapp.databinding.FragmentCadastroBinding
import com.gabriel.beerapp.ui.view.cadastro.validaCadastro.ValidaCadastroImpl
import com.gabriel.beerapp.usuario.model.UsuarioView
import com.gabriel.beerapp.util.base.BaseFragment
import com.gabriel.beerapp.util.extensions.snack
import com.gabriel.beerapp.util.extensions.toast
import com.gabriel.domain.util.resource.ResourceState
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CadastroFragment : BaseFragment<FragmentCadastroBinding, CadastroViewModel>() {

    override val viewModel: CadastroViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configuraCadastrar()
        observerCadastro()
    }

    private fun configuraCadastrar() {
        binding.btnCadastrar.setOnClickListener {
            clearErrors()
            validaCampos()
        }
    }

    private fun clearErrors() = with(binding) {
        etEmail.error = null
        etSenha.error = null
        etConfirmaSenha.error = null
    }

    private fun validaCampos() = with(binding) {
        val email = etEmail.text?.trim().toString()
        val senha = etSenha.text?.trim().toString()
        val confirmaSenha = etConfirmaSenha.text?.trim().toString()

        when (val resource =
            ValidaCadastroImpl().validaCamposCadastro(email, senha, confirmaSenha)) {
            is ResourceState.Success -> {
                viewModel.cadastraUsuario(UsuarioView(email, senha))
            }
            else -> {
                snack(requireView(), resource.message!!)
            }
        }
    }

    private fun observerCadastro() = lifecycleScope.launch {
        viewModel.cadastra.collect { resource ->
            when (resource) {
                is ResourceState.Success -> {
                    toast("Cadastro realizado com sucesso.")
                    val action = CadastroFragmentDirections.acaoGlobalParaLogin()
                    controller.navigate(action)
                }
                is ResourceState.Error -> {
                    toast(resource.message!!)
                }
                else -> {}
            }
        }
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCadastroBinding =
        FragmentCadastroBinding.inflate(layoutInflater, container, false)
}
