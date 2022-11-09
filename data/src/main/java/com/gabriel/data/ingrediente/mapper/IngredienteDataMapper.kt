package com.gabriel.data.ingrediente.mapper

import com.gabriel.data.ingrediente.model.IngredientesData
import com.gabriel.data.util.base.DataMapper
import com.gabriel.domain.ingrediente.model.Ingredientes

class IngredienteDataMapper : DataMapper<IngredientesData, Ingredientes> {
    private val mapper = TipoDataMapper()

    override fun mapToDomain(type: IngredientesData): Ingredientes {
        return Ingredientes(
            malt = mapper.mapToDomainNonNull(type.malt!!),
            hops = mapper.mapToDomainNonNull(type.hops!!)
        )
    }

    override fun mapToData(type: Ingredientes): IngredientesData {
        return IngredientesData(
            malt = mapper.mapToDataNonNull(type.malt!!),
            hops = mapper.mapToDataNonNull(type.hops!!)
        )
    }
}
