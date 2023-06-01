package com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast.favourite

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tinkoffproject.R
import com.example.tinkoffproject.databinding.FragmentFavouriteinfofragmentBinding
import com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast.mvvm.FavouriteInfoBreakfastViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FavouriteInfoBreakfastFragment : Fragment(R.layout.fragment_favouriteinfofragment) {
    private lateinit var viewModel: FavouriteInfoBreakfastViewModel
    private var binding: FragmentFavouriteinfofragmentBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[FavouriteInfoBreakfastViewModel::class.java]
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
        const val FavouriteInfoFragment_TAG = "FavouriteInfoFragment_TAG"
        fun getInstance(bundle: Bundle?): FavouriteInfoBreakfastFragment {
            val favouriteInfoBreakfastFragment = FavouriteInfoBreakfastFragment()
            favouriteInfoBreakfastFragment.arguments = bundle
            return favouriteInfoBreakfastFragment
        }
    }
}