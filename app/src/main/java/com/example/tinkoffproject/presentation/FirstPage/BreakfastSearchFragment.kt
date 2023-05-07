package com.example.tinkoffproject.presentation.FirstPage

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.tinkoffproject.R
import com.example.tinkoffproject.data.DataContainer
import com.example.tinkoffproject.data.response.product.Product
import com.example.tinkoffproject.databinding.FragmentBreakfastsearchBinding
import com.example.tinkoffproject.presentation.FirstPage.MVVM.BreakfastSearchViewModel
import com.example.tinkoffproject.presentation.FirstPage.MVVM.BreakfastSearchViewModelFactory
import kotlinx.coroutines.launch

class BreakfastSearchFragment:Fragment(R.layout.fragment_breakfastsearch) {
    private lateinit var viewModel: BreakfastSearchViewModel
    private var binding:FragmentBreakfastsearchBinding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel=ViewModelProvider(this,BreakfastSearchViewModelFactory())[BreakfastSearchViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentBreakfastsearchBinding.bind(view)
        arguments?.getString("foodName")?.let {
        }
        binding?.run{
            etFood.setOnEditorActionListener { v, actionId, event ->
                if(actionId == EditorInfo.IME_ACTION_SEARCH){
                    loadFood(etFood.text.toString())
                    true
                } else {
                    false
                }
            }
//            viewLifecycleOwner.lifecycleScope.launch {
//                val listFood=FoodRepository().getFoodName(id)
//                adapter = FoodAdapter(
//                    listFood,
//                    glide = Glide.with(this@BreakfastSearchFragment)){
//                    loadFood(etFood.text.toString())
//                }
//                binding?.foodList?.adapter=adapter
//            }
        }
    }


    private fun loadFood(query: String){
        lifecycleScope.launch {
            showLoading(true)
            viewModel.getApi(query)
            viewModel.resultApi.observe(viewLifecycleOwner){
                binding?.tvFoodName?.text=it.toString()
            }
            showLoading(false)
        }
    }
    private fun showLoading(isShow:Boolean){
        binding?.progress?.isVisible = isShow
    }
    companion object {
        const val BreakfastSearchFragment_TAG="BreakfastSearchFragment_TAG"
        fun getInstance(bundle: Bundle?): BreakfastSearchFragment {
            val breakfastSearchFragment= BreakfastSearchFragment()
            breakfastSearchFragment.arguments=bundle
            return breakfastSearchFragment
        }
    }
}