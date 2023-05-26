package com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast.favourite.model
//
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.FragmentActivity
//import androidx.viewpager2.adapter.FragmentStateAdapter
//import com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast.BreakfastSearchFragment
//import com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast.favourite.FavouritesFragment
//
//class FavoritePageAdapter(
//    fragmentActivity: FragmentActivity
//) :
//    FragmentStateAdapter(fragmentActivity) {
//    override fun getItemCount(): Int {
//        return 2
//    }
//
//    override fun createFragment(position: Int): Fragment {
//        return when (position) {
//            0 -> BreakfastSearchFragment()
//            else -> FavouritesFragment()
//        }
//    }
//}