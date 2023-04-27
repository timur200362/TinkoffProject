package com.example.tinkoffproject.presentation.FirstPage

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.tinkoffproject.R
import com.example.tinkoffproject.databinding.FragmentNightdinnersearchBinding

class NightDinnerSearchFragment:Fragment(R.layout.fragment_nightdinnersearch) {
    private var binding: FragmentNightdinnersearchBinding?=null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentNightdinnersearchBinding.bind(view)
        arguments?.getString("foodName")?.let {
        }
    }

    companion object {
        const val NightDinnerSearchFragment_TAG="NightDinnerSearchFragment_TAG"
        fun getInstance(bundle: Bundle?): NightDinnerSearchFragment {
            val nightDinnerSearchFragment= NightDinnerSearchFragment()
            nightDinnerSearchFragment.arguments=bundle
            return nightDinnerSearchFragment
        }
    }
}