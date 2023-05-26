package com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast.favourite

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.tinkoffproject.R
import com.example.tinkoffproject.databinding.FragmentFavouritesBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
//class FavouritesFragment:Fragment(R.layout.fragment_favourites) {
//    private var binding: FragmentFavouritesBinding? = null
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        binding = FragmentFavouritesBinding.bind(view)
//
//        val tabLayout = binding!!.tabLayout
//        val viewPager = binding!!.viewPager
//        viewPager.adapter = FavoritePageAdapter(requireActivity())
//        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
//            when (position) {
//                0 -> tab.text = getString(R.string.search)
//                else -> tab.text = getString(R.string.favourites)
//            }
//        }.attach()
//    }
//}
