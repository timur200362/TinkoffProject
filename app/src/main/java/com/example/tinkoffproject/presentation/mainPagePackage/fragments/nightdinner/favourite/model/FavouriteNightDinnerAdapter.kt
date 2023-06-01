package com.example.tinkoffproject.presentation.mainPagePackage.fragments.nightdinner.favourite.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.tinkoffproject.data.database.mealDatabase.MealNightDinner
import com.example.tinkoffproject.databinding.ItemFavouritesBinding

class FavouriteNightDinnerAdapter(
    private val glide: RequestManager,
    private val action: (MealNightDinner) -> Unit
) : RecyclerView.Adapter<FavouriteNightDinnerItem>() {
    private var list: List<MealNightDinner> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteNightDinnerItem =
        FavouriteNightDinnerItem(
            binding = ItemFavouritesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            glide = glide,
            action = action
        )

    override fun onBindViewHolder(holder: FavouriteNightDinnerItem, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
    fun update(list: List<MealNightDinner>) {
        this.list = list
        notifyDataSetChanged()
    }

}