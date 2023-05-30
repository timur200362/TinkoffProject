package com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast.favourite

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.tinkoffproject.R
import com.example.tinkoffproject.databinding.FragmentFavouritesBinding
import com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast.favourite.model.FavouriteAdapter
import com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast.food.BreakfastSearchFragment
import com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast.food.MainPageFragment
import com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast.mvvm.FavouritesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FavouritesFragment : Fragment(R.layout.fragment_favourites) {
    private var binding: FragmentFavouritesBinding? = null
    private lateinit var viewModel: FavouritesViewModel
    private val adapter by lazy {
        FavouriteAdapter(
            Glide.with(this)
        ) { favourite ->
            loadSearchFood(favourite.foodId)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[FavouritesViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFavouritesBinding.bind(view)
        binding?.run {
            favouriteFoodList.adapter = adapter
        }
        observeFavourite()
        loadFavourite()
        goToBreakfastSearch()
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
                    FavouriteInfoFragment.getInstance(bundle),
                    FavouriteInfoFragment.FavouriteInfoFragment_TAG
                )
                .commit()
        }
    }

    private fun goToBreakfastSearch() {
        binding?.run {
            btnGoToSearchFood.setOnClickListener {
                val bundle = Bundle()
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(
                        R.id.container,
                        BreakfastSearchFragment.getInstance(bundle),
                        BreakfastSearchFragment.BreakfastSearchFragment_TAG
                    )
                    .addToBackStack(MainPageFragment.MainPageFragment_TAG)
                    .commit()
            }
        }
    }

    companion object {
        const val FavouritesFragment_TAG = "FavouritesFragment_TAG"
        fun getInstance(bundle: Bundle?): FavouritesFragment {
            val favouritesFragment = FavouritesFragment()
            favouritesFragment.arguments = bundle
            return favouritesFragment
        }
    }
}
