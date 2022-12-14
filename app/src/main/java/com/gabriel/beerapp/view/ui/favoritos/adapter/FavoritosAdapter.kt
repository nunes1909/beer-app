package com.gabriel.beerapp.view.ui.favoritos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gabriel.beerapp.beer.model.BeerView
import com.gabriel.beerapp.databinding.ItemFavBinding
import com.gabriel.beerapp.util.extensions.limitValue
import com.gabriel.beerapp.util.extensions.tentaCarregar

class FavoritosAdapter : RecyclerView.Adapter<FavoritosAdapter.BeerViewHolder>() {

    inner class BeerViewHolder(val binding: ItemFavBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val differConfig = object : DiffUtil.ItemCallback<BeerView>() {
        override fun areItemsTheSame(oldItem: BeerView, newItem: BeerView): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

        override fun areContentsTheSame(oldItem: BeerView, newItem: BeerView): Boolean {
            return oldItem.id == newItem.id &&
                    oldItem.name == newItem.name &&
                    oldItem.tagline == newItem.tagline &&
                    oldItem.firstBrewed == newItem.firstBrewed &&
                    oldItem.description == newItem.description &&
                    oldItem.imageUrl == newItem.imageUrl &&
                    oldItem.abv == newItem.abv &&
                    oldItem.brewersTips == newItem.brewersTips
        }
    }

    private val differ = AsyncListDiffer(this, differConfig)

    var beers: List<BeerView>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun getItemCount(): Int = beers.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerViewHolder {
        return BeerViewHolder(
            ItemFavBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: BeerViewHolder, position: Int) {
        val beer = beers[position]
        holder.binding.apply {
            ivBannerItemFav.tentaCarregar(beer.imageUrl)
            tvTitleItemFav.text = beer.name?.limitValue(50, true)
            tvDescriptionItemFav.text = beer.tagline?.limitValue(80, true)
        }

        holder.itemView.setOnClickListener {
            onItemClickListener?.let {
                it(beer)
            }
        }
    }

    fun setBeerOnClickListener(listener: (BeerView) -> Unit) {
        onItemClickListener = listener
    }

    private var onItemClickListener: ((BeerView) -> Unit)? = null
}
