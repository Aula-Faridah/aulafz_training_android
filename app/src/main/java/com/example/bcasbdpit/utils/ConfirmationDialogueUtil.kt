package com.example.bcasbdpit.utils

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.example.bcasbdpit.R
import com.example.bcasbdpit.databinding.DialogueLayoutBinding

class ConfirmationDialogueUtil(private val context: Context) {

    fun showConfirmationDialog(
        title: String,
        icon: Int? = null,
        onConfirm: () -> Unit,
        onCancel: () -> Unit,
    ) {
        val dialogBuilder = AlertDialog.Builder(context)
        val alertDialog = dialogBuilder.create()

        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialogue_layout,null )
        val binding = DialogueLayoutBinding.bind(dialogView)

        binding.tvConfirm.text = title

        if (icon != null) {
            binding.ivIconDialog.visibility = View.VISIBLE
            binding.ivIconDialog.setImageResource(icon)
        } else {
            binding.ivIconDialog.visibility = View.GONE
        }

        alertDialog.setView(dialogView)

        binding.btnYes.setOnClickListener {
            onConfirm.invoke()
            alertDialog.dismiss()
        }

        binding.btnNo.setOnClickListener {
            onCancel.invoke()
            alertDialog.dismiss()
        }

        alertDialog.show()
    }
}