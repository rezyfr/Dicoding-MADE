package com.rezyfr.dicoding.favmovie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rezyfr.dicoding.core.databinding.ItemMovieLayoutBinding
import com.rezyfr.dicoding.core.domain.model.Movie

class FavoriteAdapter(private val data: ArrayList<Movie>) :
    RecyclerView.Adapter<FavoriteAdapter.MovieViewHolder>() {

    var onItemClick: ((Movie?) -> Unit)? = null

    fun setData(items: List<Movie>) {
        data.apply {
            clear()
            addAll(items)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(
            ItemMovieLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) =
        holder.bind(data[position])

    override fun getItemCount(): Int = data.size

    inner class MovieViewHolder(private val binding: ItemMovieLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.movie = movie
            binding.root.setOnClickListener {
                onItemClick?.invoke(binding.movie)
            }
        }
    }
}