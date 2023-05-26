package com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast.favourite.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.tinkoffproject.data.database.mealDatabase.MealBreakfast
import com.example.tinkoffproject.databinding.ItemFavouritesBinding

class FavouriteAdapter(
    private val list: List<MealBreakfast>,
    private val glide: RequestManager,
    private val action: (MealBreakfast) -> Unit
) : RecyclerView.Adapter<FavouriteItem>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteItem =
        FavouriteItem(
            binding = ItemFavouritesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            glide = glide,
            action = action
        )

    override fun onBindViewHolder(holder: FavouriteItem, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}