package com.chethanbhandarkar.imbd.ui.moviedetails

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.*
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

import com.chethanbhandarkar.imbd.R
import com.chethanbhandarkar.imbd.data.repository.MoviesDetailsData
import com.chethanbhandarkar.imbd.databinding.FragmentMoviedetailsBinding
import com.chethanbhandarkar.imbd.ui.home.HomeViewModel
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

		moviesDetailsViewModel.currentMovie.observe(viewLifecycleOwner, {movieDetails->

			binding.apply {

				tvAuthor.text=movieDetails.imdbrating
				tvPlot.text=movieDetails.plot


			}
		})






		binding.apply {

			tvDetailstitle.text = movieClicked.Title


			Glide.with(this@MovieDetailsFragment)
				.load(movieClicked.Poster)
				.centerCrop()
				.transition(DrawableTransitionOptions.withCrossFade())
				.error(R.drawable.ic_launcher_background)
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

		//	val action=NewsDetailsFragmentDirections.actionNewsDetailsFragmentToWebviewFragment(newsArticle.url.toString())
		//	findNavController().navigate(action)


		}

	}








}