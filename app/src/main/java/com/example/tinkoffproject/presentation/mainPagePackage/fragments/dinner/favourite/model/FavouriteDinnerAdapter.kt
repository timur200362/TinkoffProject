package com.example.tinkoffproject.presentation.mainPagePackage.fragments.dinner.favourite.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.tinkoffproject.data.database.mealDatabase.MealDinner
import com.example.tinkoffproject.databinding.ItemFavouritesBinding

class FavouriteDinnerAdapter(
    private val glide: RequestManager,
    private val action: (MealDinner) -> Unit
) : RecyclerView.Adapter<FavouriteDinnerItem>() {
    private var list: List<MealDinner> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteDinnerItem =
        FavouriteDinnerItem(
            binding = ItemFavouritesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            glide = glide,
            action = action
        )

    override fun onBindViewHolder(holder: FavouriteDinnerItem, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
    fun update(list: List<MealDinner>) {
        this.list = list
        notifyDataSetChanged()
    }

}