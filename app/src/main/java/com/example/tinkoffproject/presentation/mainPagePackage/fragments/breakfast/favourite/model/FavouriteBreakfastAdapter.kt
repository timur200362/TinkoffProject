package com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast.favourite.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.tinkoffproject.data.database.mealDatabase.MealBreakfast
import com.example.tinkoffproject.databinding.ItemFavouritesBinding

class FavouriteBreakfastAdapter(
    private val glide: RequestManager,
    private val action: (MealBreakfast) -> Unit
) : RecyclerView.Adapter<FavouriteBreakfastItem>() {
    private var list: List<MealBreakfast> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteBreakfastItem =
        FavouriteBreakfastItem(
            binding = ItemFavouritesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            glide = glide,
            action = action
        )

    override fun onBindViewHolder(holder: FavouriteBreakfastItem, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
    fun update(list: List<MealBreakfast>) {
        this.list = list
        notifyDataSetChanged()
    }

}