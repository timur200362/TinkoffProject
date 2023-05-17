package com.example.tinkoffproject.presentation.mainPagePackage

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.tinkoffproject.R
import com.example.tinkoffproject.databinding.FragmentDinnersearchBinding

class DinnerSearchFragment : Fragment(R.layout.fragment_dinnersearch) {
    private var binding: FragmentDinnersearchBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDinnersearchBinding.bind(view)
        arguments?.getString("foodName")?.let {
        }
    }

    companion object {
        const val DinnerSearchFragment_TAG = "DinnerSearchFragment_TAG"
        fun getInstance(bundle: Bundle?): DinnerSearchFragment {
            val dinnerSearchFragment = DinnerSearchFragment()
            dinnerSearchFragment.arguments = bundle
            return dinnerSearchFragment
        }
    }
}