package com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.tinkoffproject.R
import com.example.tinkoffproject.databinding.FragmentBreakfastsearchBinding
import com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast.favourite.FavouritesFragment
import com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast.mvvm.BreakfastSearchViewModel
import com.example.tinkoffproject.presentation.mainPagePackage.model.FoodAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BreakfastSearchFragment : Fragment(R.layout.fragment_breakfastsearch) {
    private lateinit var viewModel: BreakfastSearchViewModel
    private var binding: FragmentBreakfastsearchBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[BreakfastSearchViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBreakfastsearchBinding.bind(view)
        arguments?.getString("foodName")?.let {
        }
        binding?.run {
            etFood.setOnEditorActionListener { _, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    loadFood(etFood.text.toString())
                    true
                } else {
                    false
                }
            }
        }
        loadFavourites()
    }
    private fun loadFood(query: String) {
        viewModel.getApi(query)
        viewModel.resultApi.observe(viewLifecycleOwner) {
            binding?.foodList?.adapter =
                FoodAdapter(it, Glide.with(this@BreakfastSearchFragment)) { product ->
                    loadFoodInfo(product.id)
                }
        }
    }


    private fun loadFoodInfo(id: Int) {
        val bundle = Bundle()
        bundle.putInt("foodId", id)
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(
                R.id.container,
                FoodInfoFragment.getInstance(bundle),
                FoodInfoFragment.FoodInfoFragment_TAG
            )
            .addToBackStack(null)
            .commit()
    }
    private fun loadFavourites() {
        binding?.run{
            btnGoToFavourite.setOnClickListener{
                val bundle = Bundle()
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(
                        R.id.container,
                        FavouritesFragment.getInstance(bundle),
                        FoodInfoFragment.FoodInfoFragment_TAG
                    )
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    companion object {
        const val BreakfastSearchFragment_TAG = "BreakfastSearchFragment_TAG"
        fun getInstance(bundle: Bundle?): BreakfastSearchFragment {
            val breakfastSearchFragment = BreakfastSearchFragment()
            breakfastSearchFragment.arguments = bundle
            return breakfastSearchFragment
        }
    }
}