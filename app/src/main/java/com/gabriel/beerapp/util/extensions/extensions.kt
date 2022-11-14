package com.gabriel.beerapp.util.extensions

import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import coil.load
import com.google.android.material.snackbar.Snackbar

fun Fragment.toast(mensagem: String, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(requireContext(), mensagem, duration).show()
}

fun Fragment.snack(view: View, mensagem: String, duration: Int = Snackbar.LENGTH_LONG) {
    val snackbar = Snackbar.make(view, mensagem, duration)
    snackbar.setBackgroundTint(resources.getColor(android.R.color.holo_red_dark))
    snackbar.setAction("OK") {}
    snackbar.show()
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun String.limitValue(limit: Int, ellipsize: Boolean): String {
    val ellEnd = if (ellipsize) "..." else ""
    if (this.length > limit) {
        val first = 0
        return "${this.substring(first, limit)}$ellEnd"
    }
    return this
}

fun ImageView.tentaCarregar(url: String? = null) {
    load(url) {
//        fallback(R.drawable.erro)
//        error(R.drawable.erro)
        placeholder(androidx.appcompat.R.color.material_grey_600)
    }
}

fun rand(start: Int, end: Int): Int {
    require(start <= end) { "Illegal Argument" }
    return (start..end).random()
}
