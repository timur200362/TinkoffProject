package com.example.tinkoffproject.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.tinkoffproject.R
import com.example.tinkoffproject.databinding.FragmentBreakfastsearchBinding
import kotlinx.coroutines.launch
import timber.log.Timber

class BreakfastSearchFragment:Fragment(R.layout.fragment_breakfastsearch) {
    private var binding:FragmentBreakfastsearchBinding?=null
    //private val api = Container.foodApi

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentBreakfastsearchBinding.bind(view)
        arguments?.getString("foodName")?.let {
        }
//        binding?.run{
//            tiFood.setOnClickListener{
//                loadFood("pizza")
//            }
//        }
    }

//    private fun loadFood(query: String){
//        lifecycleScope.launch {
//            api.getFood(query).also {
//                //showName(it.)
//                Timber.e("$query")
//            }
//        }
//    }
//    private fun showName(name:String){
//        binding?.tvFoodName?.run {
//            text="$name"
//        }
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