package com.gabriel.data.ingrediente.mapper

import com.gabriel.data.ingrediente.model.TipoData
import com.gabriel.data.util.base.DataMapper
import com.gabriel.domain.ingrediente.model.Tipo

class TipoDataMapper : DataMapper<TipoData, Tipo> {
    override fun mapToDomain(type: TipoData): Tipo {
        return Tipo(name = type.name)
    }

    override fun mapToData(type: Tipo): TipoData {
        return TipoData(name = type.name)
    }
}
