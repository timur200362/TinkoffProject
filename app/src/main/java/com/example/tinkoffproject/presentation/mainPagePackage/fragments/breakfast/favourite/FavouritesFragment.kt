package com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast.favourite

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.tinkoffproject.R
import com.example.tinkoffproject.databinding.FragmentFavouritesBinding
import com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast.BreakfastSearchFragment
import com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast.FoodInfoFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavouritesFragment : Fragment(R.layout.fragment_favourites) {
    private var binding: FragmentFavouritesBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFavouritesBinding.bind(view)
    }
    private fun loadSearchFood() {
        binding?.run{
            btnGoToSearchFood.setOnClickListener{
                val bundle = Bundle()
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(
                        R.id.container,
                        BreakfastSearchFragment.getInstance(bundle),
                        BreakfastSearchFragment.BreakfastSearchFragment_TAG
                    )
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
