package com.example.tinkoffproject.presentation.FirstPage.Model

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.tinkoffproject.databinding.ItemFoodBinding

class FoodItem(
    private val binding: ItemFoodBinding,
    private val glide: RequestManager,
    private val action: (Food) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(foodList: Food) {
        with(binding) {
            tvFoodName.text = foodList.name

//            glide
//                .load(foodList.icon)
//                .into(ivFoodIcon)

            root.setOnClickListener {
                action(foodList)
            }
        }
    }
}