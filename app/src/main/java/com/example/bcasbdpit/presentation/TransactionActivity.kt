package com.example.bcasbdpit.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bcasbdpit.adapter.ListTransactionAdapter
import com.example.bcasbdpit.databinding.ActivityTransactionBinding
import com.example.bcasbdpit.model.TransactionModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TransactionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTransactionBinding

    private var listTransactionAdapter = ListTransactionAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvListTransaction.adapter = listTransactionAdapter
        listTransactionAdapter.setData(createDummyListTransaction())


        listTransactionAdapter.setOnClickTransaction { transaction ->
//            Toast.makeText(this, transaction.transferDestination, Toast.LENGTH_SHORT).show()
                navigateToDetailTransaction(transaction)
        }
    }

    private fun navigateToDetailTransaction(data: TransactionModel){
        val intent = Intent(this, DetailTransactionActivity::class.java)
        intent.putExtra(TRANSACTION_KEY,data)
        startActivity(intent)
    }



    private fun createDummyListTransaction(): MutableList<TransactionModel> {
        return mutableListOf(
            TransactionModel(
                transferType = "QR",
                transferDestination = "Mandiri",
                transferDate = "25/04/24",
                transferStatus = "Success",
                transferAmount = 250000.0
            ),
            TransactionModel(
                transferType = "QR",
                transferDestination = "BCA",
                transferDate = "26/04/24",
                transferStatus = "Success",
                transferAmount = 50000.0
            ),
            TransactionModel(
                transferType = "QR",
                transferDestination = "BSI",
                transferDate = "25/04/24",
                transferStatus = "Success",
                transferAmount = 250000.0
            ),
            TransactionModel(
                transferType = "QR",
                transferDestination = "BCAS",
                transferDate = "26/04/24",
                transferStatus = "Success",
                transferAmount = 50000.0
            ),
            TransactionModel(
                transferType = "QR",
                transferDestination = "BRI",
                transferDate = "25/04/24",
                transferStatus = "Success",
                transferAmount = 250000.0
            ),
            TransactionModel(
                transferType = "QR",
                transferDestination = "BNI",
                transferDate = "26/04/24",
                transferStatus = "Success",
                transferAmount = 50000.0
            ),
            TransactionModel(
                transferType = "QR",
                transferDestination = "BTN",
                transferDate = "25/04/24",
                transferStatus = "Success",
                transferAmount = 250000.0
            ),
            TransactionModel(
                transferType = "QR",
                transferDestination = "Muammalat",
                transferDate = "26/04/24",
                transferStatus = "Success",
                transferAmount = 50000.0
            ),
            TransactionModel(
                transferType = "QR",
                transferDestination = "Mega",
                transferDate = "25/04/24",
                transferStatus = "Success",
                transferAmount = 250000.0
            ),
            TransactionModel(
                transferType = "QR",
                transferDestination = "BNI",
                transferDate = "26/04/24",
                transferStatus = "Success",
                transferAmount = 50000.0
            ),
            TransactionModel(
                transferType = "QR",
                transferDestination = "BRI",
                transferDate = "25/04/24",
                transferStatus = "Success",
                transferAmount = 250000.0
            ),
            TransactionModel(
                transferType = "QR",
                transferDestination = "BCA",
                transferDate = "26/04/24",
                transferStatus = "Success",
                transferAmount = 50000.0
            ),
            TransactionModel(
                transferType = "QR",
                transferDestination = "Mandiri",
                transferDate = "25/04/24",
                transferStatus = "Success",
                transferAmount = 250000.0
            ),
            TransactionModel(
                transferType = "QR",
                transferDestination = "BCAS",
                transferDate = "26/04/24",
                transferStatus = "Success",
                transferAmount = 50000.0
            ),
            TransactionModel(
                transferType = "QR",
                transferDestination = "BSI",
                transferDate = "25/04/24",
                transferStatus = "Success",
                transferAmount = 250000.0
            ),
            TransactionModel(
                transferType = "QR",
                transferDestination = "Mandiri",
                transferDate = "26/04/24",
                transferStatus = "Success",
                transferAmount = 50000.0
            ),
        )
    }

    companion object {
        const val TRANSACTION_KEY = "transaction_key"
    }
}

