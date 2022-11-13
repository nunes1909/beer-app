package com.gabriel.beerapp.ui.view.favoritos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gabriel.beerapp.databinding.FragmentFavoritosBinding
import com.gabriel.beerapp.util.base.BaseFragmentIn
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoritosFragment : BaseFragmentIn<FragmentFavoritosBinding, FavoritosViewModel>() {

    override val viewModel: FavoritosViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFavoritosBinding =
        FragmentFavoritosBinding.inflate(layoutInflater, container, false)
}
