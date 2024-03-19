package com.example.bcasbdpit.presentation.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bcasbdpit.adapter.ListTransactionAdapter
import com.example.bcasbdpit.databinding.FragmentInboxBinding
import com.example.bcasbdpit.model.TransactionModel
import com.example.bcasbdpit.presentation.DetailTransactionActivity
import com.example.bcasbdpit.presentation.TransactionActivity

class InboxFragment : Fragment() {
    private var _binding: FragmentInboxBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInboxBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var listTransactionAdapter = ListTransactionAdapter()

        binding.rvListTransaction.adapter = listTransactionAdapter
        listTransactionAdapter.setData(createDummyListTransaction())


        listTransactionAdapter.setOnClickTransaction { transaction ->
//            Toast.makeText(this, transaction.transferDestination, Toast.LENGTH_SHORT).show()
            navigateToDetailTransaction(transaction)
        }
    }

    private fun navigateToDetailTransaction(data: TransactionModel){
        val intent = Intent(getActivity(), DetailTransactionActivity::class.java)
        intent.putExtra(TransactionActivity.TRANSACTION_KEY,data)
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

}