package com.gabriel.remote.ingrediente.mapper

import com.gabriel.data.ingrediente.model.TipoData
import com.gabriel.remote.ingrediente.model.TipoRemote
import com.gabriel.remote.util.base.RemoteMapper

class TipoRemoteMapper : RemoteMapper<TipoRemote, TipoData> {
    override fun mapToData(type: TipoRemote): TipoData {
        return TipoData(name = type.name)
    }

    override fun mapToRemote(type: TipoData): TipoRemote {
        return TipoRemote(name = type.name)
    }
}
