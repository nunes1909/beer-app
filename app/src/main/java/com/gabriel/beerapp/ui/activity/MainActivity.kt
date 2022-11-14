package com.gabriel.beerapp.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.gabriel.beerapp.R
import com.gabriel.beerapp.databinding.ActivityMainBinding
import com.gabriel.beerapp.util.extensions.hide
import com.gabriel.beerapp.util.extensions.show
import com.gabriel.beerapp.util.preferences.dataStore
import com.gabriel.strategy.constants.ConstantsUtil.KEY_BOTTOM_NAV
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        inicializaView()
        resolveNavs()
    }

    private fun inicializaView() {
        navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        navController = navHostFragment.navController

        navController.addOnDestinationChangedListener { _, navDestination, _ ->
            title = navDestination.label
        }

        binding.bottomNavigation.apply {
            setupWithNavController(navController)
            setOnNavigationItemReselectedListener { }
        }
    }

    private fun resolveNavs() = lifecycleScope.launch {
        dataStore.data.collect { preferences ->
            preferences[booleanPreferencesKey(KEY_BOTTOM_NAV)]?.let {
                if (it) {
                    binding.bottomNavigation.show()
                    supportActionBar?.show()
                } else {
                    binding.bottomNavigation.hide()
                    supportActionBar?.hide()
                }
            }
        }
    }
}
