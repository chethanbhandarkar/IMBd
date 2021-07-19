package com.chethanbhandarkar.imbd.ui.wishlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.chethanbhandarkar.imbd.R
import com.chethanbhandarkar.imbd.databinding.FragmentWishlistBinding

class WishlistFragment : Fragment() {
	private lateinit var dashboardViewModel: WishlistViewModel
	private var _binding: FragmentWishlistBinding? = null
	private val binding get() = _binding!!

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		dashboardViewModel =
			ViewModelProvider(this).get(WishlistViewModel::class.java)
		_binding = FragmentWishlistBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		binding.tvWlComingsoon.text=getString(R.string.string_coming_soon)

	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}