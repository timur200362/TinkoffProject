package com.example.tinkoffproject.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.tinkoffproject.R
import com.example.tinkoffproject.databinding.FragmentMainpageBinding

class BreakfastSearchFragment:Fragment(R.layout.fragment_breakfastsearch) {
    private var binding:FragmentMainpageBinding?=null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentMainpageBinding.bind(view)
    }

    companion object {
        const val BreakfastSearchFragment_TAG="BreakfastSearchFragment_TAG"
        fun getInstance(bundle: Bundle?):BreakfastSearchFragment {
            val breakfastSearchFragment=BreakfastSearchFragment()
            breakfastSearchFragment.arguments=bundle
            return breakfastSearchFragment
        }
    }
}