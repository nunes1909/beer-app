package com.gabriel.beerapp.util.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.gabriel.beerapp.util.preferences.dataStore
import com.gabriel.domain.util.constants.ConstantsUtil.KEY_BOTTOM_NAV
import kotlinx.coroutines.launch

abstract class BaseFragment<viewBinding : ViewBinding, viewModel : ViewModel> : Fragment() {

    private var _binding: viewBinding? = null
    protected val binding get() = _binding!!

    protected abstract val viewModel: viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        configuraVisibilityBottomNav()
    }

    private fun configuraVisibilityBottomNav() {
        lifecycleScope.launch {
            requireContext().dataStore.edit { preferences ->
                preferences[booleanPreferencesKey(KEY_BOTTOM_NAV)] = true
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
