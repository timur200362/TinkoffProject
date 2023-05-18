package com.example.tinkoffproject.presentation.mainPagePackage.Fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tinkoffproject.R
import com.example.tinkoffproject.databinding.FragmentFoodinfoBinding
import com.example.tinkoffproject.presentation.mainPagePackage.MVVM.FoodInfoViewModel

class FoodInfoFragment : Fragment(R.layout.fragment_foodinfo) {
    private lateinit var viewModel:FoodInfoViewModel
    private var binding:FragmentFoodinfoBinding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel=ViewModelProvider(this)[FoodInfoViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFoodinfoBinding.bind(view)
        arguments?.getInt("foodId")?.let { loadTitle(it) }
        viewModel.resultApiTitle.observe(viewLifecycleOwner){
            showTitle(it.title)
        }
    }

    private fun loadTitle(foodId:Int){
        viewModel.getTitle(foodId)
    }
    private fun showTitle(title: String) {
        binding?.tvFoodNameInput?.run {
            text = title
        }
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