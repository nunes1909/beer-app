package com.gabriel.beerapp.util.base

import android.os.Bundle
import android.view.*
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.gabriel.beerapp.NavGraphDirections
import com.gabriel.beerapp.R
import com.gabriel.beerapp.util.preferences.dataStore
import com.gabriel.strategy.constants.ConstantsUtil.KEY_BOTTOM_NAV
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

abstract class BaseFragmentOut<viewBinding : ViewBinding, viewModel : ViewModel> : Fragment() {

    private var _binding: viewBinding? = null
    protected val binding get() = _binding!!
    protected abstract val viewModel: viewModel

    protected val controller by lazy { findNavController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraVisibilityBottomNav()
    }

    private fun configuraVisibilityBottomNav() {
        lifecycleScope.launch {
            requireContext().dataStore.edit { preferences ->
                preferences[booleanPreferencesKey(KEY_BOTTOM_NAV)] = false
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = getViewBinding(inflater, container)
        return binding.root
    }

    abstract fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): viewBinding?

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
