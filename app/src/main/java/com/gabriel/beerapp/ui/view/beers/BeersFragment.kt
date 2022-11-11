package com.gabriel.beerapp.ui.view.beers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gabriel.beerapp.databinding.FragmentBeersBinding
import com.gabriel.beerapp.util.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class BeersFragment : BaseFragment<FragmentBeersBinding, BeersViewModel>() {

    override val viewModel: BeersViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configuraRecycler()
    }

    private fun configuraRecycler() {
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentBeersBinding =
        FragmentBeersBinding.inflate(layoutInflater, container, false)
}
