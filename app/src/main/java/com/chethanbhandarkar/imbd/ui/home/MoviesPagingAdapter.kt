package com.chethanbhandarkar.imbd.ui.home

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.chethanbhandarkar.imbd.R
import com.chethanbhandarkar.imbd.data.repository.MoviesDataList
import com.chethanbhandarkar.imbd.databinding.EachMoviesdataBinding

class MoviesPagingAdapter(private val listener: OnItemClickListenr) :
	PagingDataAdapter<MoviesDataList.MoviesHomeData, MoviesPagingAdapter.NewsViewHolder>(NEWS_COMPARATOR) {
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
		val binding =
			EachMoviesdataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
		return NewsViewHolder(binding)
	}

	@RequiresApi(Build.VERSION_CODES.O)
	override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
		val currentItem = getItem(position)
		if (currentItem != null) {
			holder.bind(currentItem)
		}

	}

	inner class NewsViewHolder(private val binding: EachMoviesdataBinding) : RecyclerView.ViewHolder(binding.root) {



		init {
			binding.root.setOnClickListener {
				val position = bindingAdapterPosition
				if (position != RecyclerView.NO_POSITION) {
					val item = getItem(position)
					if (item != null) {
						listener.onItemClick(item)
					}

				}
			}
		}

		@RequiresApi(Build.VERSION_CODES.O)
		fun bind(movies: MoviesDataList.MoviesHomeData) {
			binding.apply {
				tvTitle.text = movies.Title
				tvYear.text = movies.Year

				Glide.with(itemView)
					.load(movies.Poster)
					.centerCrop()
					.transition(DrawableTransitionOptions.withCrossFade())
					.error(R.drawable.ic_launcher_background)
					.into(ivPoster)
			}

		}
	}

	interface OnItemClickListenr {
		fun onItemClick(movies: MoviesDataList.MoviesHomeData)
	}

	companion object {
		private val NEWS_COMPARATOR = object : DiffUtil.ItemCallback<MoviesDataList.MoviesHomeData>() {
			override fun areItemsTheSame(
				oldItem: MoviesDataList.MoviesHomeData,
				newItem: MoviesDataList.MoviesHomeData
			) = oldItem.imdbID == newItem.imdbID

			override fun areContentsTheSame(
				oldItem: MoviesDataList.MoviesHomeData,
				newItem: MoviesDataList.MoviesHomeData
			) = oldItem == newItem

		}
	}

}