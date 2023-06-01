package com.example.tinkoffproject.presentation.mainPagePackage.fragments.dinner.favourite

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.tinkoffproject.R
import com.example.tinkoffproject.databinding.FragmentFavouritesBinding
import com.example.tinkoffproject.presentation.mainPagePackage.MainPageFragment
import com.example.tinkoffproject.presentation.mainPagePackage.fragments.dinner.favourite.model.FavouriteDinnerAdapter
import com.example.tinkoffproject.presentation.mainPagePackage.fragments.dinner.food.DinnerSearchFragment
import com.example.tinkoffproject.presentation.mainPagePackage.fragments.dinner.mvvm.FavouritesDinnerViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavouritesDinnerFragment : Fragment(R.layout.fragment_favourites) {
    private var binding: FragmentFavouritesBinding? = null
    private lateinit var viewModel: FavouritesDinnerViewModel
    private val adapter by lazy {
        FavouriteDinnerAdapter(
            Glide.with(this)
        ) { favourite ->
            loadFavouriteList(favourite.foodId)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[FavouritesDinnerViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFavouritesBinding.bind(view)
        binding?.run {
            favouriteFoodList.adapter = adapter
        }
        observeFavourite()
        loadFavourite()
        goToDinnerSearch()
    }

    private fun observeFavourite() {
        viewModel.resultFavourite.observe(viewLifecycleOwner) {
            adapter.update(it)
        }
    }

    private fun loadFavourite() {
        viewModel.fetchFavourite()
    }

    private fun loadFavouriteList(id: Double) {
        binding?.run {
            val bundle = Bundle()
            bundle.putDouble("favouriteId", id)
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(
                    R.id.container,
                    FavouriteInfoDinnerFragment.getInstance(bundle),
                    FavouriteInfoDinnerFragment.FavouriteInfoDinnerFragment_TAG
                )
                .commit()
        }
    }

    private fun goToDinnerSearch() {
        binding?.run {
            btnGoToSearchFood.setOnClickListener {
                val bundle = Bundle()
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(
                        R.id.container,
                        DinnerSearchFragment.getInstance(bundle),
                        DinnerSearchFragment.DinnerSearchFragment_TAG
                    )
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    companion object {
        const val FavouritesDinnerFragment_TAG = "FavouritesDinnerFragment_TAG"
        fun getInstance(bundle: Bundle?): FavouritesDinnerFragment {
            val favouritesDinnerFragment = FavouritesDinnerFragment()
            favouritesDinnerFragment.arguments = bundle
            return favouritesDinnerFragment
        }
    }
}
