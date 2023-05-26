package com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast.favourite

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.tinkoffproject.R
import com.example.tinkoffproject.databinding.FragmentFoodinfoBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FavouriteInfoFragment : Fragment(R.layout.fragment_favouriteinfofragment) {
    private var binding: FragmentFoodinfoBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFoodinfoBinding.bind(view)
    }
}