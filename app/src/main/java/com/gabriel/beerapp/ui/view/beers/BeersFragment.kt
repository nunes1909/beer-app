package com.gabriel.beerapp.ui.view.beers

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.gabriel.beerapp.beer.model.BeerView
import com.gabriel.beerapp.databinding.FragmentBeersBinding
import com.gabriel.beerapp.ui.view.adapters.BeersAdapter
import com.gabriel.beerapp.util.base.BaseFragment
import com.gabriel.beerapp.util.extensions.toast
import com.gabriel.domain.util.constants.ConstantsUtil.TAG_BEERS_FRAGMENT
import com.gabriel.domain.util.resource.ResourceState
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class BeersFragment : BaseFragment<FragmentBeersBinding, BeersViewModel>() {

    override val viewModel: BeersViewModel by viewModel()
    private val adapter by lazy { BeersAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configuraRecycler()
        configuraPesquisa()
        configuraClickAdapter()
        observerBeers()
    }

    private fun configuraRecycler() = with(binding) {
        rvBeers.adapter = adapter
        rvBeers.layoutManager = GridLayoutManager(requireContext(), 2)
        rvBeers.requestFocus()
    }

    private fun configuraPesquisa() {
        binding.etPesquisa.addTextChangedListener(searchBeersWatcher())
    }

    private fun configuraClickAdapter() {
        adapter.setBeerOnClickListener { beerView ->
            val action = BeersFragmentDirections.acaoBeersParaDetalhes(beerView)
            findNavController().navigate(action)
        }
    }

    private fun searchBeersWatcher() = object : TextWatcher {
        override fun onTextChanged(query: CharSequence, p1: Int, p2: Int, p3: Int) {
            if (query.isNotEmpty()) {
                viewModel.getAll(query.toString())
            } else {
                viewModel.getAll()
            }
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            // Sem implementação
        }

        override fun afterTextChanged(p0: Editable?) {
            // Sem implementação
        }
    }

    private fun observerBeers() = lifecycleScope.launch {
        viewModel.list.collect { resource ->
            when (resource) {
                is ResourceState.Success -> {
                    adapter.beers = resource.data!!
                }
                is ResourceState.Error -> {
                    toast("Não foi possível obter as Beers.")
                    Log.e(TAG_BEERS_FRAGMENT, "Error -> ${resource.cod}/${resource.message}")
                }
                else -> {}
            }
        }
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentBeersBinding =
        FragmentBeersBinding.inflate(layoutInflater, container, false)
}
