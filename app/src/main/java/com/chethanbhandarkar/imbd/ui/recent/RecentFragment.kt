package com.chethanbhandarkar.imbd.ui.recent

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chethanbhandarkar.imbd.R

class RecentFragment : Fragment() {

    companion object {
        fun newInstance() = RecentFragment()
    }

    private lateinit var viewModel: RecentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.recent_fragment, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RecentViewModel::class.java)
        // TODO: Use the ViewModel
    }

}