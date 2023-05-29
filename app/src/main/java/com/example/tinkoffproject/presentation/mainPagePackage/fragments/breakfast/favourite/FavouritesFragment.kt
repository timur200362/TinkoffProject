package com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast.favourite

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.tinkoffproject.R
import com.example.tinkoffproject.data.database.mealDatabase.MealDatabase
import com.example.tinkoffproject.databinding.FragmentFavouritesBinding
import com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast.BreakfastSearchFragment
import com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast.MainPageFragment
import com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast.favourite.model.FavouriteAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FavouritesFragment : Fragment(R.layout.fragment_favourites) {
    private var binding: FragmentFavouritesBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFavouritesBinding.bind(view)
        binding?.run {
        }
        lifecycleScope.launch {
            loadFavourite()
        }
        goToBreakfastSearch()
    }

    private suspend fun loadFavourite() {
        val db = MealDatabase.getDatabase(requireContext())
        val userDao = db.mealDao()
        binding?.favouriteFoodList?.adapter =
            FavouriteAdapter(
                userDao.getFavourite(),
                Glide.with(this@FavouritesFragment)
            ) { favourite ->
                loadSearchFood(favourite.foodId.toDouble())
            }
    }

    private fun loadSearchFood(id: Double) {
        binding?.run {
            btnGoToSearchFood.setOnClickListener {
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
