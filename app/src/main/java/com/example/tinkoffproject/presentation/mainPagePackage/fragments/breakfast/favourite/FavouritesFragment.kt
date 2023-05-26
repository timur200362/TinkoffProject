package com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast.favourite

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.tinkoffproject.R
import com.example.tinkoffproject.databinding.FragmentFavouritesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavouritesFragment : Fragment(R.layout.fragment_favourites) {
    private var binding: FragmentFavouritesBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFavouritesBinding.bind(view)
    }
}
