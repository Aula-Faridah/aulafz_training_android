package com.example.bcasbdpit.presentation.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.bcasbdpit.base.BaseFragment
import com.example.bcasbdpit.databinding.FragmentNotificationBinding

class NotificationFragment : BaseFragment<FragmentNotificationBinding>() {
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNotificationBinding {
        return FragmentNotificationBinding.inflate(inflater, container, false)
    }

    override fun setUpView() {
    }

}