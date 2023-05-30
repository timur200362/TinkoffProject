package com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast.favourite

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.tinkoffproject.R
import com.example.tinkoffproject.data.database.mealDatabase.MealDatabase
import com.example.tinkoffproject.databinding.FragmentFavouriteinfofragmentBinding
import com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast.mvvm.FavouriteInfoViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class FavouriteInfoFragment : Fragment(R.layout.fragment_favouriteinfofragment) {
    private lateinit var viewModel:FavouriteInfoViewModel
    private var binding: FragmentFavouriteinfofragmentBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel=ViewModelProvider(this)[FavouriteInfoViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFavouriteinfofragmentBinding.bind(view)
        arguments?.getDouble("favouriteId")?.let {
            viewModel.resultFavourite.observe(viewLifecycleOwner){ _ ->
                loadFavouriteInfo(it)
            }
        }
    }

    private fun loadFavouriteInfo(favouriteId: Double) {
        lifecycleScope.launch {
            binding?.run {
                tvFoodNameInput.text = viewModel.fetchFavouriteInfoById(favouriteId).toString()
            }
        }
    }

    companion object {
        const val FavouriteInfoFragment_TAG = "FavouriteInfoFragment_TAG"
        fun getInstance(bundle: Bundle?): FavouriteInfoFragment {
            val favouriteInfoFragment = FavouriteInfoFragment()
            favouriteInfoFragment.arguments = bundle
            return favouriteInfoFragment
        }
    }
}