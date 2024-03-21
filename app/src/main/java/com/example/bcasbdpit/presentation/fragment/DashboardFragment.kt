package com.example.bcasbdpit.presentation.fragment

import HorizontalItemDecoration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bcasbdpit.R
import com.example.bcasbdpit.adapter.AccountBalanceAdapter
import com.example.bcasbdpit.adapter.PromoAdapter
import com.example.bcasbdpit.base.BaseFragment
import com.example.bcasbdpit.databinding.FragmentDashboardBinding
import com.example.bcasbdpit.model.AccountBalanceModel
import com.example.bcasbdpit.model.MenuDashboardModel
import com.example.bcasbdpit.model.PromoModel
import com.example.bcasbdpit.presentation.fragment.adapter.DashboardMenuAdapter

class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {
//    private var _binding: FragmentDashboardBinding? = null
//    private val binding get() = _binding!!
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//    }

    private lateinit var menuAdapter: DashboardMenuAdapter
    private lateinit var balanceAdapter: AccountBalanceAdapter
    private lateinit var promoAdapter: PromoAdapter


    private val horizontalItemDecoration by lazy {
        HorizontalItemDecoration(
            resources.getDimensionPixelOffset(R.dimen.spacing16),
            true
        )
    }

    override fun inflateBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ): FragmentDashboardBinding {
        return FragmentDashboardBinding.inflate(inflater, container, false)
    }

    override fun setUpView() {
        setupViewMenu()
        setupViewAccountBalance()
        setupViewPromo()
    }

    private fun setupViewMenu() {
        menuAdapter = DashboardMenuAdapter(
            menuData = populateDataMenu(), context = binding.root.context
        )

        binding.componentMenu.gridMenu.adapter = menuAdapter
        binding.componentMenu.gridMenu.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                Toast.makeText(
                    binding.root.context, populateDataMenu()[position].menuName, Toast.LENGTH_SHORT
                ).show()
            }
    }

    private fun setupViewAccountBalance() {
        balanceAdapter = AccountBalanceAdapter(
            data = populateDataAccountNumber()
        )

        binding.componentAccount.rvAccountBalance.adapter = balanceAdapter
        binding.componentAccount.rvAccountBalance.layoutManager = LinearLayoutManager(
            binding.root.context, LinearLayoutManager.HORIZONTAL, false
        )
        binding.componentAccount.rvAccountBalance.apply {
            if (itemDecorationCount <= 0) {
                addItemDecoration(horizontalItemDecoration)
            }
        }
    }

    private fun setupViewPromo() {
        promoAdapter = PromoAdapter(
            data = populatePromo()
        )

        binding.componentPromo.rvPromo.adapter = promoAdapter
        binding.componentPromo.rvPromo.layoutManager = LinearLayoutManager(
            binding.root.context, LinearLayoutManager.HORIZONTAL, false
        )
        binding.componentPromo.rvPromo.apply {
            if (itemDecorationCount <= 0) {
                addItemDecoration(horizontalItemDecoration)
            }
        }
    }

    private fun populateDataMenu(): List<MenuDashboardModel> {
        return listOf(
            MenuDashboardModel(R.drawable.fa_brands__telegram_plane, "Transfer"),
            MenuDashboardModel(R.drawable.grommet_icons__basket, "Pembelian"),
            MenuDashboardModel(R.drawable.majesticons__creditcard_hand_line, "Pembayaran"),
            MenuDashboardModel(R.drawable.cardless, "Cardless"),
            MenuDashboardModel(
                R.drawable.icon_park_outline__history_query, "Histori Transaksi Transaksi"
            ),
            MenuDashboardModel(
                R.drawable.icon_park_outline__transaction, "Mutasi Rekening Rekening"
            ),
            MenuDashboardModel(R.drawable.mosque, "Jadwal Sholat"),
        )
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

    private fun populatePromo(): List<PromoModel> {
        return listOf(
            PromoModel(imagePromo = R.drawable.promo1),
            PromoModel(imagePromo = R.drawable.promo2),
            PromoModel(imagePromo = R.drawable.promo3),
            PromoModel(imagePromo = R.drawable.promo4),
            PromoModel(imagePromo = R.drawable.promo5)
        )
    }

}