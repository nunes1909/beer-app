package com.gabriel.remote.ingrediente.mapper

import com.gabriel.data.ingrediente.model.IngredientesData
import com.gabriel.remote.ingrediente.model.IngredientesRemote
import com.gabriel.remote.util.base.RemoteMapper

class IngredienteRemoteMapper : RemoteMapper<IngredientesRemote, IngredientesData> {
    private val mapper = TipoRemoteMapper()

    override fun mapToData(type: IngredientesRemote): IngredientesData {
        return IngredientesData(
            malt = mapper.mapToDataNonNull(type.malt!!),
            hops = mapper.mapToDataNonNull(type.hops!!)
        )
    }

    override fun mapToRemote(type: IngredientesData): IngredientesRemote {
        return IngredientesRemote(
            malt = mapper.mapToRemoteNonNull(type.malt!!),
            hops = mapper.mapToRemoteNonNull(type.hops!!)
        )
    }
}
