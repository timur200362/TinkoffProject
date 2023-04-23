package com.example.tinkoffproject.presentation

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.tinkoffproject.R
import com.example.tinkoffproject.data.Container
import com.example.tinkoffproject.databinding.FragmentBreakfastsearchBinding
import kotlinx.coroutines.launch

class BreakfastSearchFragment:Fragment(R.layout.fragment_breakfastsearch) {
    private var binding:FragmentBreakfastsearchBinding?=null
        private val api = Container.foodApi

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentBreakfastsearchBinding.bind(view)
        arguments?.getString("foodName")?.let {
        }
        binding?.run{
            tiFood.setOnClickListener{
                loadFood(etFood.text.toString())
            }
        }
    }

    private fun loadFood(query: String){
        lifecycleScope.launch {
            api.getFood(query).also {
                it.products?.get(0)?.let { it1 -> it1.id?.let { it2 -> showName(it2) } }
            }
        }
    }
    private fun showName(name:Int){
        binding?.tvFoodName?.run {
            text="$name"
        }
    }
//    private fun showLoading(isShow:Boolean){
//        binding?.progress?.isVisible=true
//    }

    companion object {
        const val BreakfastSearchFragment_TAG="BreakfastSearchFragment_TAG"
        fun getInstance(bundle: Bundle?):BreakfastSearchFragment {
            val breakfastSearchFragment=BreakfastSearchFragment()
            breakfastSearchFragment.arguments=bundle
            return breakfastSearchFragment
        }
    }
}