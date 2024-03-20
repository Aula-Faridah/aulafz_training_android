package com.example.bcasbdpit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bcasbdpit.databinding.FragmentDashboardBinding
import com.example.bcasbdpit.databinding.ItemAccountBalanceBinding
import com.example.bcasbdpit.model.AccountBalanceModel

class AccountBalanceAdapter(
    private val data: List<AccountBalanceModel>
) : RecyclerView.Adapter<AccountBalanceAdapter.AccountBalanceViewHolder>()  //adapter adalah yang mengisi

{
    inner class AccountBalanceViewHolder( // yang menampilkan (view)
        val binding: ItemAccountBalanceBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: AccountBalanceModel){
            binding.tvSavingType.text = data.savingType
            binding.tvAccountNumber.text = data.accountNumber
            binding.tvBalance.text = data.savingBalance.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountBalanceViewHolder {
        return AccountBalanceViewHolder(
            ItemAccountBalanceBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: AccountBalanceViewHolder, position: Int) {
        holder.bind(data[position])
    }
}