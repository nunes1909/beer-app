package com.gabriel.beerapp.ui.view.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.gabriel.beerapp.databinding.FragmentLoginBinding
import com.gabriel.beerapp.util.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>() {

    override val viewModel: LoginViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goLogin()
        goCadastrar()
    }

    private fun goLogin() {
        binding.btnLoginLogar.setOnClickListener {

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
