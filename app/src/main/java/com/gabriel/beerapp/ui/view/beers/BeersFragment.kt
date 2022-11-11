package com.gabriel.beerapp.ui.view.beers

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.gabriel.beerapp.beer.model.BeerView
import com.gabriel.beerapp.databinding.FragmentBeersBinding
import com.gabriel.beerapp.ui.adapters.BeersAdapter
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
        viewModel.list.collect { resourceView ->
            when (resourceView) {
                is ResourceState.Success -> {
                    exibeBeers(resourceView)
                }
                is ResourceState.Error -> {
                    toast("Um erro ocorreu.")
                    Log.e(TAG_BEERS_FRAGMENT, "Error -> ${resourceView.cod}/${resourceView.message}")
                }
                else -> {}
            }
        }
    }

    private fun exibeBeers(resource: ResourceState<List<BeerView>>) {
        resource.data?.let {
            adapter.beers = it
        }
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentBeersBinding =
        FragmentBeersBinding.inflate(layoutInflater, container, false)
}
