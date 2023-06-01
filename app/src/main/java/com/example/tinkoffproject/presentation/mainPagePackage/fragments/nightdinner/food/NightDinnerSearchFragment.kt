package com.example.tinkoffproject.presentation.mainPagePackage.fragments.nightdinner.food

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.tinkoffproject.R
import com.example.tinkoffproject.databinding.FragmentNightdinnersearchBinding
import com.example.tinkoffproject.presentation.mainPagePackage.fragments.dinner.favourite.FavouritesDinnerFragment
import com.example.tinkoffproject.presentation.mainPagePackage.fragments.nightdinner.favourite.FavouritesNightDinnerFragment
import com.example.tinkoffproject.presentation.mainPagePackage.fragments.nightdinner.mvvm.NightDinnerSearchViewModel
import com.example.tinkoffproject.presentation.mainPagePackage.model.FoodAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class NightDinnerSearchFragment : Fragment(R.layout.fragment_nightdinnersearch) {
    private lateinit var viewModel: NightDinnerSearchViewModel
    private var binding: FragmentNightdinnersearchBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[NightDinnerSearchViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNightdinnersearchBinding.bind(view)
        arguments?.getString("foodName")?.let {
        }
        binding?.run {
            try {
                etFood.setOnEditorActionListener { _, actionId, _ ->
                    if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                        loadFood(etFood.text.toString())
                        true
                    } else {
                        false
                    }
                }
            } catch (ex: Exception) {
                if (context != null) {
                    Toast.makeText(context, "Введено некорректное название", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
        goToFavourites()
    }

    private fun loadFood(query: String) {
        viewModel.getApi(query)
        viewModel.resultApi.observe(viewLifecycleOwner) {
            binding?.foodList?.adapter =
                FoodAdapter(it, Glide.with(this)) { product ->
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
                NightDinnerInfoFragment.getInstance(bundle),
                NightDinnerInfoFragment.NightDinnerInfoFragment_TAG
            )
            .addToBackStack(null)
            .commit()
    }

    private fun goToFavourites() {
        binding?.run {
            btnGoToFavourite.setOnClickListener {
                val bundle = Bundle()
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(
                        R.id.container,
                        FavouritesNightDinnerFragment.getInstance(bundle),
                        FavouritesNightDinnerFragment.FavouritesNightDinnerFragment_TAG
                    )
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    companion object {
        const val NightDinnerSearchFragment_TAG = "NightDinnerSearchFragment_TAG"
        fun getInstance(bundle: Bundle?): NightDinnerSearchFragment {
            val nightDinnerSearchFragment = NightDinnerSearchFragment()
            nightDinnerSearchFragment.arguments = bundle
            return nightDinnerSearchFragment
        }
    }
}