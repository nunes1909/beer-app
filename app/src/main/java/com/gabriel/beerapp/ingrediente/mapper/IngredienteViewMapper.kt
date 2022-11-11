package com.gabriel.beerapp.ingrediente.mapper

import com.gabriel.beerapp.ingrediente.model.IngredientesView
import com.gabriel.beerapp.util.base.ViewMapper
import com.gabriel.domain.ingrediente.model.Ingredientes

class IngredienteViewMapper : ViewMapper<IngredientesView, Ingredientes> {
    private val mapper = TipoViewMapper()

    override fun mapToDomain(type: IngredientesView): Ingredientes {
        return Ingredientes(
            malt = mapper.mapToDomainNonNull(type.malt!!),
            hops = mapper.mapToDomainNonNull(type.hops!!)
        )
    }

    override fun mapToView(type: Ingredientes): IngredientesView {
        return IngredientesView(
            malt = mapper.mapToViewNonNull(type.malt!!),
            hops = mapper.mapToViewNonNull(type.hops!!)
        )
    }
}