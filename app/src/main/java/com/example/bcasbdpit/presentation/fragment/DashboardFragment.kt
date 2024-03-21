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
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
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
import com.example.bcasbdpit.presentation.viewmodel.DashboardViewModel

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

    private val viewModel: DashboardViewModel by viewModels()

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
//        setupViewMenu()
//        setupViewAccountBalance()
//        setupViewPromo()


        viewModel.getHomeMenu()
        viewModel.getAccountBalance()
        viewModel.getPromo()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.homeMenu.observe(viewLifecycleOwner) {
            setupViewMenu(it)
        }
        viewModel.accountBalance.observe(viewLifecycleOwner) {
            setupViewAccountBalance(it)
        }
        viewModel.promo.observe(viewLifecycleOwner){
            setupViewPromo(it)
        }
    }

    private fun setupViewMenu(data: List<MenuDashboardModel>) {
        menuAdapter = DashboardMenuAdapter(
            menuData = data,
            context = binding.root.context
        )

        binding.componentMenu.gridMenu.adapter = menuAdapter
        binding.componentMenu.gridMenu.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                Toast.makeText(
                    binding.root.context, data[position].menuName, Toast.LENGTH_SHORT
                ).show()
            }
    }

    private fun setupViewAccountBalance(data: List<AccountBalanceModel>) {
        balanceAdapter = AccountBalanceAdapter(
            data = data
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

    private fun setupViewPromo(data: List<PromoModel>) {
        promoAdapter = PromoAdapter(
            data = data
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
}