package com.example.tinkoffproject.presentation.FirstPage

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.tinkoffproject.R
import com.example.tinkoffproject.data.DataContainer
import com.example.tinkoffproject.databinding.FragmentBreakfastsearchBinding
import kotlinx.coroutines.launch

class BreakfastSearchFragment:Fragment(R.layout.fragment_breakfastsearch) {
    private var binding:FragmentBreakfastsearchBinding?=null
        private val api = DataContainer.foodApi

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentBreakfastsearchBinding.bind(view)
        arguments?.getString("foodName")?.let {
        }
        binding?.run{
            etFood.addTextChangedListener{
                loadFood(etFood.text.toString())
            }
        }
    }


    private fun loadFood(query: String){
        lifecycleScope.launch {
            api.getFood(query).also {
                var idStr=""
                it.products?.forEach{
                    idStr+="${it?.id} "
                }
                binding?.tvFoodName?.text=idStr
            }
        }
    }
    private fun showName(id:Int){
        binding?.tvFoodName?.run {
            text="$id"
        }
    }
//    private fun showLoading(isShow:Boolean){
//        binding?.progress?.isVisible=true
//    }

    companion object {
        const val BreakfastSearchFragment_TAG="BreakfastSearchFragment_TAG"
        fun getInstance(bundle: Bundle?): BreakfastSearchFragment {
            val breakfastSearchFragment= BreakfastSearchFragment()
            breakfastSearchFragment.arguments=bundle
            return breakfastSearchFragment
        }
    }
}