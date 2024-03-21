package com.example.bcasbdpit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView
import com.example.bcasbdpit.databinding.ItemAccountBalanceBinding
import com.example.bcasbdpit.databinding.ItemPromoBinding
import com.example.bcasbdpit.model.PromoModel

class PromoAdapter(
    private val data: List<PromoModel>

) : RecyclerView.Adapter<PromoAdapter.PromoViewHolder>() {

    inner class PromoViewHolder(
        val binding: ItemPromoBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: PromoModel) {
            binding.ivPromo.setImageResource(data.imagePromo)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromoViewHolder {
        return PromoViewHolder(
            ItemPromoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: PromoViewHolder, position: Int) {
        holder.bind(data[position])
    }
}