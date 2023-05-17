package com.example.tinkoffproject.presentation.mainPagePackage

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.tinkoffproject.R
import com.example.tinkoffproject.databinding.FragmentFoodinfoBinding

class FoodInfoFragment : Fragment(R.layout.fragment_foodinfo) {

    private var binding:FragmentFoodinfoBinding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFoodinfoBinding.bind(view)
        arguments?.getString("foodName")?.let { loadName(it) }
    }

    private fun loadName(query:String){
    }

    companion object {
        const val FoodInfoFragment_TAG = "FoodInfoFragment_TAG"
        fun getInstance(bundle: Bundle?): FoodInfoFragment {
            val foodInfoFragment = FoodInfoFragment()
            foodInfoFragment.arguments = bundle
            return foodInfoFragment
        }
    }
}