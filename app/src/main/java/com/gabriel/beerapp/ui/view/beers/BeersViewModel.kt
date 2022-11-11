package com.gabriel.beerapp.ui.view.beers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gabriel.beerapp.beer.mapper.BeerViewMapper
import com.gabriel.beerapp.beer.model.BeerView
import com.gabriel.domain.beer.model.Beer
import com.gabriel.domain.beer.useCase.GetAllBeersUseCase
import com.gabriel.domain.util.resource.ResourceState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BeersViewModel(
    private val mapper: BeerViewMapper,
    private val getAllBeersUseCase: GetAllBeersUseCase
) : ViewModel() {

    init {
        getAll()
    }

    private val _list = MutableStateFlow<ResourceState<List<BeerView>>>(ResourceState.Loading())
    val list: StateFlow<ResourceState<List<BeerView>>> = _list

    private fun getAll() = viewModelScope.launch {
        val resourceDomain = getAllBeersUseCase.getAll()
        _list.value = validateResource(resourceDomain)
    }

    private fun validateResource(resource: ResourceState<List<Beer>>):
            ResourceState<List<BeerView>> {
        if (resource.data != null) {
            val listView = mapper.mapToViewNonNull(resource.data!!)
            return ResourceState.Success(listView)
        }
        return ResourceState.Error(cod = resource.cod, message = resource.message)
    }
}