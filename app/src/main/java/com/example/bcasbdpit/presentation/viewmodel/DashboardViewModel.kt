package com.example.bcasbdpit.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bcasbdpit.R
import com.example.bcasbdpit.data.remote.MenuDashboardRemoteDataSource
import com.example.bcasbdpit.model.AccountBalanceModel
import com.example.bcasbdpit.model.MenuDashboardModel
import com.example.bcasbdpit.model.MenuDashboardResponse
import com.example.bcasbdpit.model.PromoModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.nio.channels.MulticastChannel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val menuDashboardRemoteDataSource: MenuDashboardRemoteDataSource
) : ViewModel() {

    private val _homeMenu = MutableLiveData<MenuDashboardResponse>()
    val homeMenu: LiveData<MenuDashboardResponse>
        get() = _homeMenu

    private val _homeMenuError = MutableLiveData<String>()

    val homeMenuError: LiveData<String>
        get() = _homeMenuError

    private val _accountBalance = MutableLiveData<List<AccountBalanceModel>>()

    val accountBalance: LiveData<List<AccountBalanceModel>>
        get() = _accountBalance

    private val _promo = MutableLiveData<List<PromoModel>>()

    val promo: LiveData<List<PromoModel>>
        get() = _promo

//    private fun populateDataMenu(): List<MenuDashboardModel> {
//        return listOf(
//            MenuDashboardModel(R.drawable.fa_brands__telegram_plane, "Transfer"),
//            MenuDashboardModel(R.drawable.grommet_icons__basket, "Pembelian"),
//            MenuDashboardModel(R.drawable.majesticons__creditcard_hand_line, "Pembayaran"),
//            MenuDashboardModel(R.drawable.cardless, "Cardless"),
//            MenuDashboardModel(
//                R.drawable.icon_park_outline__history_query, "Histori Transaksi Transaksi"
//            ),
//            MenuDashboardModel(
//                R.drawable.icon_park_outline__transaction, "Mutasi Rekening Rekening"
//            ),
//            MenuDashboardModel(R.drawable.mosque, "Jadwal Sholat"),
//        )
//    }


    fun getHomeMenu() = viewModelScope.launch(Dispatchers.IO) {
//        _homeMenu.postValue(populateDataMenu())
        menuDashboardRemoteDataSource.getMenuDashboard().let {
            if (it.isSuccessful) {
                _homeMenu.postValue(it.body())
            } else {
                _homeMenuError.postValue(it.message())
            }
        }
    }

    private fun populateDataAccountNumber(): List<AccountBalanceModel> {
        return listOf(
            AccountBalanceModel(
                savingType = "Mudharabah",
                accountNumber = "001234",
                savingBalance = 15600700.00
            ),
            AccountBalanceModel(
                savingType = "Wadiah",
                accountNumber = "112344",
                savingBalance = 98904078.00
            ),
            AccountBalanceModel(
                savingType = "Wadiah non Bonus",
                accountNumber = "778902",
                savingBalance = 25688222.00
            ),
        )
    }

    fun getAccountBalance() = viewModelScope.launch(Dispatchers.IO) {
        _accountBalance.postValue(populateDataAccountNumber())
    }

    private fun populatePromo(): List<PromoModel> {
        return listOf(
            PromoModel(imagePromo = R.drawable.promo1),
            PromoModel(imagePromo = R.drawable.promo2),
            PromoModel(imagePromo = R.drawable.promo3),
            PromoModel(imagePromo = R.drawable.promo4),
            PromoModel(imagePromo = R.drawable.promo5)
        )
    }

    fun getPromo() = viewModelScope.launch(Dispatchers.IO) {
        _promo.postValue(populatePromo())
    }
}