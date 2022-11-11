package com.gabriel.beerapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gabriel.beerapp.beer.model.BeerView
import com.gabriel.beerapp.databinding.ItemBeersBinding

class BeersAdapter : RecyclerView.Adapter<BeersAdapter.BeerViewHolder>() {

    inner class BeerViewHolder(val binding: ItemBeersBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val differConfig = object : DiffUtil.ItemCallback<BeerView>() {
        override fun areItemsTheSame(oldItem: BeerView, newItem: BeerView): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

        override fun areContentsTheSame(oldItem: BeerView, newItem: BeerView): Boolean {
            return oldItem.id == newItem.id
        }
    }

    private val differ = AsyncListDiffer(this, differConfig)

    var beers: List<BeerView>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun getItemCount(): Int = beers.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerViewHolder {
        return BeerViewHolder(
            ItemBeersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: BeerViewHolder, position: Int) {
        val beer = beers[position]
        holder.binding.apply {

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
