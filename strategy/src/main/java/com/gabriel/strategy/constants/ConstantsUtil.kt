package com.gabriel.strategy.constants

object ConstantsUtil {
    // region retrofit
    const val BASE_URL = "https://api.punkapi.com/v2/"
    // endregion

    // region data store
    const val KEY_BOTTOM_NAV = "exibeBottomNav"
    // endregion

    // region selects firebase
    const val COLECAO_FAVORITOS = "favoritos"
    const val USUARIO_ID = "usuarioId"
    const val BEER_ID = "id"
    // endregion

    // region tags and msgs
    const val TAG_GET_ALL_BEERS_DS = "GetAllBeers"
    const val MSG_GET_ALL_BEERS_DS = "GetAllBeersDataSourceImpl/getAll: "

    const val TAG_DELETE_BEERS_DS = "DeleteBeer"
    const val MSG_DELETE_BEERS_DS = "DeleteBeerDataSourceImpl/deleteBeer: "

    const val TAG_GET_BEERS_FAV_DS = "GetBeersFav"
    const val MSG_GET_BEERS_FAV_DS = "GetBeersFavDataSourceImpl/getBeersFav: "

    const val TAG_SAVE_BEERS_DS = "SaveBeerRemote"
    const val MSG_SAVE_BEERS_DS = "SaveBeerRemoteDataSourceImpl/saveBeer: "

    const val TAG_VERIFY_EXISTS_DS = "VerifyIfExists"
    const val MSG_VERIFY_EXISTS_DS = "VerifyIfExistsDataSourceImpl/verifyIfExists: "

    const val TAG_BEERS_FRAGMENT = "BeersFragment"
    const val TAG_DETALHES_FRAGMENT = "DetalhesFragment"
    // endregion
}
