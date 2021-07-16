package com.chethanbhandarkar.imbd.ui.moviedetails

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.*
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment

import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

import com.chethanbhandarkar.imbd.R
import com.chethanbhandarkar.imbd.databinding.FragmentMoviedetailsBinding

class MovieDetailsFragment : Fragment() {
	private val args by navArgs<MovieDetailsFragmentArgs>()



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

		binding.apply {

			tvDetailstitle.text = movieClicked.Title
			tvDetailsdescription.text = movieClicked.Type

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