package com.example.tinkoffproject.presentation.mainPagePackage

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.tinkoffproject.R
import com.example.tinkoffproject.databinding.FragmentSnackssearchBinding

class SnacksSearchFragment:Fragment(R.layout.fragment_snackssearch) {
    private var binding: FragmentSnackssearchBinding?=null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentSnackssearchBinding.bind(view)
        arguments?.getString("foodName")?.let {
        }
    }

    companion object {
        const val SnacksSearchFragment_TAG="SnacksSearchFragment_TAG"
        fun getInstance(bundle: Bundle?): SnacksSearchFragment {
            val snackDinnerSearchFragment= SnacksSearchFragment()
            snackDinnerSearchFragment.arguments=bundle
            return snackDinnerSearchFragment
        }
    }
}