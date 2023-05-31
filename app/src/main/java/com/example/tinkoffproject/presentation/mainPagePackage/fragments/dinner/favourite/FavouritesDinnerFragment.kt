package com.example.tinkoffproject.presentation.mainPagePackage.fragments.dinner.favourite

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.tinkoffproject.R
import com.example.tinkoffproject.databinding.FragmentFavouritesBinding
import com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast.favourite.model.FavouriteBreakfastAdapter
import com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast.food.BreakfastSearchFragment
import com.example.tinkoffproject.presentation.mainPagePackage.MainPageFragment
import com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast.mvvm.FavouritesBreakfastViewModel
import com.example.tinkoffproject.presentation.mainPagePackage.fragments.dinner.food.DinnerSearchFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavouritesDinnerFragment : Fragment(R.layout.fragment_favourites) {
    private var binding: FragmentFavouritesBinding? = null
    private lateinit var viewModel: FavouritesBreakfastViewModel
    private val adapter by lazy {
        FavouriteBreakfastAdapter(
            Glide.with(this)
        ) { favourite ->
            loadSearchFood(favourite.foodId)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[FavouritesBreakfastViewModel::class.java]
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

    private fun loadSearchFood(id: Double) {
        binding?.run {
            val bundle = Bundle()
            bundle.putDouble("favouriteId", id)
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(
                    R.id.container,
                    FavouriteInfoDinnerFragment.getInstance(bundle),
                    FavouriteInfoDinnerFragment.FavouriteInfoFragment_TAG
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
                    .addToBackStack(MainPageFragment.MainPageFragment_TAG)
                    .commit()
            }
        }
    }

    companion object {
        const val FavouritesFragment_TAG = "FavouritesFragment_TAG"
        fun getInstance(bundle: Bundle?): FavouritesDinnerFragment {
            val favouritesFragment = FavouritesDinnerFragment()
            favouritesFragment.arguments = bundle
            return favouritesFragment
        }
    }
}
