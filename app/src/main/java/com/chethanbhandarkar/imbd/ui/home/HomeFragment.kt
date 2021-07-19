package com.chethanbhandarkar.imbd.ui.home

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.chethanbhandarkar.imbd.R
import com.chethanbhandarkar.imbd.data.repository.MoviesDataList
import com.chethanbhandarkar.imbd.databinding.FragmentHomeBinding
import com.chethanbhandarkar.imbd.ui.topheadlines.LoadingStateAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), MoviesPagingAdapter.OnItemClickListenr {
	private var _binding: FragmentHomeBinding? = null
	private val homeViewModel by viewModels<HomeViewModel>()
	private val binding get() = _binding!!
	private var searching: Boolean = false

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		_binding = FragmentHomeBinding.inflate(inflater, container, false)
		val toolbar: androidx.appcompat.widget.Toolbar = binding.toolBar
		(requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		setHasOptionsMenu(true)
		val adapter = MoviesPagingAdapter(this)
		homeViewModel.getTopHeadlines(null)

		binding.apply {
			rvMovielist.setHasFixedSize(true)
			rvMovielist.layoutManager = GridLayoutManager(activity, 3)
			rvMovielist.adapter = adapter.withLoadStateHeaderAndFooter(
				header = LoadingStateAdapter {
					adapter.retry()
				},
				footer = LoadingStateAdapter {
					adapter.retry()
				},
			)


			adapter.addLoadStateListener {
				binding.apply {
					if (adapter.itemCount == 0 && searching) {
						noDataLottie.isVisible = true
						tvTopheadlines.text = getString(R.string.string_nomovies)
					} else if (adapter.itemCount == 0) {
						searchingLottie.isVisible = true
						tvTopheadlines.text = getString(R.string.string_findingmovies)
					} else {
						noDataLottie.isVisible = false
						searchingLottie.isVisible = false
						tvTopheadlines.text = getString(R.string.string_topmovies)

					}
				}
			}
		}


		homeViewModel.movies.observe(viewLifecycleOwner, {
			adapter.submitData(viewLifecycleOwner.lifecycle, it)
		})

	}

	override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
		super.onCreateOptionsMenu(menu, inflater)
		inflater.inflate(R.menu.search_bar_menu, menu)
		val search = menu.findItem(R.id.nav_search)


		val searchView = search?.actionView as SearchView
		searchView.queryHint = "Search for Movies, Series, Shows .."

		searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
			override fun onQueryTextSubmit(query: String?): Boolean {
				if (query != null) {
					searching = true
					binding.rvMovielist.scrollToPosition(0)
					homeViewModel.getTopHeadlines(query)
					searchView.clearFocus()
				}
				return true
			}
			override fun onQueryTextChange(newText: String?): Boolean {
				return true
			}
		})

	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}

	override fun onItemClick(movies: MoviesDataList.MoviesHomeData) {
		val action = HomeFragmentDirections.actionNavigationHomeToNavigationMoviedetails(movies)
		findNavController().navigate(action)
	}
}