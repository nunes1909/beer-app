package com.gabriel.remote.beer.dataSource

import com.gabriel.data.beer.dataSource.DeleteBeerDataSource
import com.gabriel.strategy.constants.ConstantsUtil.BEER_ID
import com.gabriel.strategy.constants.ConstantsUtil.COLECAO_FAVORITOS
import com.gabriel.strategy.constants.ConstantsUtil.USUARIO_ID
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class DeleteBeerDataSourceImpl(
    private val firestore: FirebaseFirestore,
    private val firebaseAuth: FirebaseAuth
) : DeleteBeerDataSource {
    override suspend fun deleteBeer(beerId: Int) {
        val colecao = firestore.collection(COLECAO_FAVORITOS)

        colecao
            .whereEqualTo(USUARIO_ID, firebaseAuth.currentUser?.uid)
            .whereEqualTo(BEER_ID, beerId)
            .get()
            .addOnSuccessListener { documents ->
                for (doc in documents) {
                    colecao.document(doc.id).delete()
                }
            }
    }
}
