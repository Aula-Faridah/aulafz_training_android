package com.example.bcasbdpit.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TransactionModel(
    val transferType: String,
    val transferDestination: String,
    val transferDate: String,
    val transferStatus: String,
    val transferAmount: Double
):Parcelable