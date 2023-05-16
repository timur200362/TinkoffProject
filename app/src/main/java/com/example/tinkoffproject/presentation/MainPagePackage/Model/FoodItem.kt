package com.example.tinkoffproject.presentation.MainPagePackage.Model

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.tinkoffproject.data.response.product.Product
import com.example.tinkoffproject.databinding.ItemFoodBinding

class FoodItem(
    private val binding: ItemFoodBinding,
    private val glide: RequestManager,
    private val action: (Product) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(food: Product) {
        with(binding) {
            tvFoodName.text = food.title

            glide
                .load("https://www.oum.ru/upload/iblock/dcc/dcc519cc127f7b838f5344be0107e9ba.jpg")
                .into(ivFoodIcon)

            root.setOnClickListener {
                action(food)
            }
        }
    }
}