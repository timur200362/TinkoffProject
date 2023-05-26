package com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast.favourite.model

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.tinkoffproject.data.database.mealDatabase.MealBreakfast
import com.example.tinkoffproject.databinding.ItemFavouritesBinding

class FavouriteItem(
    private val binding: ItemFavouritesBinding,
    private val glide: RequestManager,
    private val action: (MealBreakfast) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(food: MealBreakfast) {
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