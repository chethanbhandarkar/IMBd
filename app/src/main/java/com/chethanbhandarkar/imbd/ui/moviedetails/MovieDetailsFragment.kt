package com.chethanbhandarkar.imbd.ui.moviedetails

import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.chethanbhandarkar.imbd.R
import com.chethanbhandarkar.imbd.databinding.FragmentMoviedetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailsFragment : Fragment() {
	private val args by navArgs<MovieDetailsFragmentArgs>()
	private val moviesDetailsViewModel by viewModels<MovieDetailsViewModel>()

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		return inflater.inflate(R.layout.fragment_moviedetails, container, false)
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		val binding = FragmentMoviedetailsBinding.bind(view)
		val movieClicked = args.movieClick
		moviesDetailsViewModel.getMovieDetail(movieClicked.imdbID)
		moviesDetailsViewModel.currentMovie.observe(viewLifecycleOwner, { movieDetails ->

			binding.apply {
				tvRatings.text = movieDetails.imdbrating
				tvPlot.text = movieDetails.plot
				tvGenre.text = movieDetails.genre
				tvLanguage.text = movieDetails.language
				tvYear2.text = movieDetails.year.substring(0, 4)
				tvRatings2.text = movieDetails.metascore
				tvStars.text = movieDetails.actors
				tvWriter.text = movieDetails.writer
				tvDirector.text = movieDetails.director
				tvBoxoffice.text = movieDetails.boxoffice
				Glide.with(this@MovieDetailsFragment)
					.load(movieClicked.Poster)
					.centerCrop()
					.transition(DrawableTransitionOptions.withCrossFade())
					.error(R.drawable.black_bg).into(ivDetailsSmallPoster)
			}
		})


		binding.apply {
			tvDetailstitle.text = movieClicked.Title
			Glide.with(this@MovieDetailsFragment)
				.load(movieClicked.Poster)
				.centerCrop()
				.transition(DrawableTransitionOptions.withCrossFade())
				.error(R.drawable.black_bg)
				.listener(object : RequestListener<Drawable> {
					override fun onLoadFailed(
						e: GlideException?,
						model: Any?,
						target: Target<Drawable>?,
						isFirstResource: Boolean
					): Boolean {
						progressBar.isVisible = false
						return false
					}

					override fun onResourceReady(
						resource: Drawable?,
						model: Any?,
						target: Target<Drawable>?,
						dataSource: DataSource?,
						isFirstResource: Boolean
					): Boolean {
						progressBar.isVisible = false

						return false
					}

				})
				.into(ivDetailsimage)
		}

		binding.btnMoredetails.setOnClickListener {
			val sendIntent: Intent = Intent().apply {
				action = Intent.ACTION_SEND
				putExtra(Intent.EXTRA_TEXT, "I am watching ".plus(movieClicked.Title).plus(" - ").plus(movieClicked.Year).plus("\n").plus("Check it out now").plus("\n").plus("https://www.imdb.com/title/").plus(movieClicked.imdbID))
				putExtra(Intent.EXTRA_TITLE, "Share ".plus(movieClicked.Title).plus(" to.."))
				type = "text/plain"
			}
			val shareIntent = Intent.createChooser(sendIntent, "Share to")
			startActivity(shareIntent)
		}

	}

}