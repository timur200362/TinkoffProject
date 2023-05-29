package com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast.favourite

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.tinkoffproject.R
import com.example.tinkoffproject.data.database.mealDatabase.MealDatabase
import com.example.tinkoffproject.databinding.FragmentFoodinfoBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class FavouriteInfoFragment : Fragment(R.layout.fragment_favouriteinfofragment) {
    private var binding: FragmentFoodinfoBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFoodinfoBinding.bind(view)
        arguments?.getInt("favouriteId")?.let { loadFavouriteInfo(it.toDouble()) }
    }

    private fun loadFavouriteInfo(favouriteId: Double) {
        val db = MealDatabase.getDatabase(requireContext())
        val userDao = db.mealDao()
        lifecycleScope.launch {
            binding?.run {
                //tvFoodNameInput.text=userDao.getFavouriteOnId(favouriteId).toString()
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