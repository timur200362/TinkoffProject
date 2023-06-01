package com.example.tinkoffproject.presentation.mainPagePackage.fragments.nightdinner.favourite

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tinkoffproject.R
import com.example.tinkoffproject.databinding.FragmentFavouriteinfofragmentBinding
import com.example.tinkoffproject.presentation.mainPagePackage.fragments.nightdinner.mvvm.FavouriteInfoNightDinnerViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FavouriteInfoNightDinnerFragment : Fragment(R.layout.fragment_favouriteinfofragment) {
    private lateinit var viewModel: FavouriteInfoNightDinnerViewModel
    private var binding: FragmentFavouriteinfofragmentBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[FavouriteInfoNightDinnerViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFavouriteinfofragmentBinding.bind(view)
        arguments?.getDouble("favouriteId")?.let {
            viewModel.resultFavourite.observe(viewLifecycleOwner) { _ ->
                loadFavouriteInfo(it)
            }
        }
    }

    private fun loadFavouriteInfo(favouriteId: Double) {
        binding?.run {
            tvFoodNameInput.text = viewModel.fetchFavouriteInfoById(favouriteId).toString()
        }
    }

    companion object {
        const val FavouriteInfoNightDinnerFragment_TAG = "FavouriteInfoNightDinnerFragment_TAG"
        fun getInstance(bundle: Bundle?): FavouriteInfoNightDinnerFragment {
            val favouriteInfoNightDinnerFragment = FavouriteInfoNightDinnerFragment()
            favouriteInfoNightDinnerFragment.arguments = bundle
            return favouriteInfoNightDinnerFragment
        }
    }
}