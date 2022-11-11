package com.gabriel.beerapp.ingrediente.mapper

import com.gabriel.beerapp.ingrediente.model.TipoView
import com.gabriel.beerapp.util.base.ViewMapper
import com.gabriel.domain.ingrediente.model.Tipo

class TipoViewMapper : ViewMapper<TipoView, Tipo> {
    override fun mapToDomain(type: TipoView): Tipo {
        return Tipo(name = type.name)
    }

    override fun mapToView(type: Tipo): TipoView {
        return TipoView(name = type.name)
    }
}