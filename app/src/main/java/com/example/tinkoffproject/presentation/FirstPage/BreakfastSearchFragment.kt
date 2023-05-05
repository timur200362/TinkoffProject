package com.example.tinkoffproject.presentation.FirstPage

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.tinkoffproject.R
import com.example.tinkoffproject.data.DataContainer
import com.example.tinkoffproject.data.FoodRepository
import com.example.tinkoffproject.databinding.FragmentBreakfastsearchBinding
import com.example.tinkoffproject.presentation.FirstPage.Model.FoodAdapter
import kotlinx.coroutines.launch

class BreakfastSearchFragment:Fragment(R.layout.fragment_breakfastsearch) {
    private var binding:FragmentBreakfastsearchBinding?=null
    private val api = DataContainer.foodApi
    private var adapter:FoodAdapter?=null


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
            api.getFood(query).also {
                showLoading(true)
                var idStr = 0
                var nameStr = ""
                it.products?.forEach{
                    idStr = it?.id!!
                    api.getFoodInfo(idStr).also {
                        nameStr+="${it.title} "
                    }
                }
                binding?.tvFoodName?.text="${nameStr}"
                showLoading(false)
            }
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