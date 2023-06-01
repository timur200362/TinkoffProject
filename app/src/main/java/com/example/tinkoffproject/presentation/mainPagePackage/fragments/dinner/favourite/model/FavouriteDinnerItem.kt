package com.example.tinkoffproject.presentation.mainPagePackage.fragments.dinner.favourite.model

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.tinkoffproject.data.database.mealDatabase.MealDinner
import com.example.tinkoffproject.databinding.ItemFavouritesBinding

class FavouriteDinnerItem(
    private val binding: ItemFavouritesBinding,
    private val glide: RequestManager,
    private val action: (MealDinner) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(food: MealDinner) {
        with(binding) {
            tvFavouriteFoodName.text = food.title

            glide
                .load("https://www.oum.ru/upload/iblock/dcc/dcc519cc127f7b838f5344be0107e9ba.jpg")
                .into(ivFavouriteFoodIcon)

            cardView.setOnClickListener {
                action(food)
            }
        }
    }
}