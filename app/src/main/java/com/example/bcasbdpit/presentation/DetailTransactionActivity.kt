package com.example.bcasbdpit.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bcasbdpit.R
import com.example.bcasbdpit.databinding.ActivityDetailTransactionBinding
import com.example.bcasbdpit.model.TransactionModel
import com.example.bcasbdpit.presentation.TransactionActivity.Companion.TRANSACTION_KEY
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailTransactionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailTransactionBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val transaction = intent.getParcelableExtra<TransactionModel>(TRANSACTION_KEY)

        binding.tvTransferType.text = transaction?.transferType
        binding.tvTransferDestination.text = transaction?.transferDestination
        binding.tvTransferDate.text = transaction?.transferDate
        binding.tvTransferStatus.text = transaction?.transferStatus
        binding.tvTransferAmount.text = transaction?.transferAmount.toString()

    }
}