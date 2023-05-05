package com.example.tinkoffproject.presentation.FirstPage.Model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.tinkoffproject.databinding.ItemFoodBinding

class FoodAdapter(
    private val list: List<Food>,
    private val glide: RequestManager,
    private val action: (Food) -> Unit
) : RecyclerView.Adapter<FoodItem>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodItem =
        FoodItem(
            binding = ItemFoodBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            glide = glide,
            action = action
        )

    override fun onBindViewHolder(holder: FoodItem, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}