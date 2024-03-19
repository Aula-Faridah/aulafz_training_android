package com.example.bcasbdpit.presentation.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.bcasbdpit.adapter.MessageTabAdapter
import com.example.bcasbdpit.base.BaseFragment
import com.example.bcasbdpit.databinding.FragmentHistoryBinding

class HistoryFragment : BaseFragment<FragmentHistoryBinding>() {
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHistoryBinding {
        return FragmentHistoryBinding.inflate(inflater, container, false)
    }

    override fun setUpView() {

    }


}