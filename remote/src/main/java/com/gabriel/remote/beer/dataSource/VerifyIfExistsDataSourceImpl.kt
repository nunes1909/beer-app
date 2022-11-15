package com.gabriel.remote.beer.dataSource

import android.util.Log
import com.gabriel.data.beer.dataSource.VerifyIfExistsDataSource
import com.gabriel.strategy.constants.ConstantsUtil
import com.gabriel.strategy.constants.ConstantsUtil.BEER_ID
import com.gabriel.strategy.constants.ConstantsUtil.MSG_VERIFY_EXISTS_DS
import com.gabriel.strategy.constants.ConstantsUtil.TAG_VERIFY_EXISTS_DS
import com.gabriel.strategy.constants.ConstantsUtil.USUARIO_ID
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlin.coroutines.suspendCoroutine

class VerifyIfExistsDataSourceImpl(
    private val firestore: FirebaseFirestore,
    private val firebaseAuth: FirebaseAuth
) : VerifyIfExistsDataSource {
    override suspend fun verifyIfExists(beerId: Int): Boolean {
        return suspendCoroutine { continuation ->
            val colecao = firestore.collection(ConstantsUtil.COLECAO_FAVORITOS)
            colecao
                .whereEqualTo(USUARIO_ID, firebaseAuth.currentUser?.uid)
                .whereEqualTo(BEER_ID, beerId)
                .get()
                .addOnSuccessListener { documents ->
                    if (documents.isEmpty) {
                        continuation.resumeWith(Result.success(false))
                    } else {
                        continuation.resumeWith(Result.success(true))
                    }
                }

            colecao.get().addOnFailureListener { exception ->
                Log.e(TAG_VERIFY_EXISTS_DS, MSG_VERIFY_EXISTS_DS, exception)
            }
        }
    }
}
