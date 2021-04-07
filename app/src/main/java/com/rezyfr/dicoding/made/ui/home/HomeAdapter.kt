package com.rezyfr.dicoding.made.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.rezyfr.dicoding.core.domain.model.Movie
import com.rezyfr.dicoding.made.R
import com.rezyfr.dicoding.made.databinding.ItemMovieGridLayoutBinding

class HomeAdapter : PagingDataAdapter<Movie, HomeAdapter.ViewHolder>(object : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }
}) {

    var onItemClick: ((Movie?) -> Unit)? = null

    class ViewHolder(val binding: ItemMovieGridLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val item = getItem(position)
        holder.apply {
            binding.movie = item
            binding.root.setOnClickListener {
                onItemClick?.invoke(binding.movie)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_movie_grid_layout,
                parent,
                false
            )
        )

}