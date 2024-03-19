package com.example.bcasbdpit.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bcasbdpit.databinding.FragmentAdminBinding
import com.example.bcasbdpit.presentation.RegisterActivity

class AdminFragment : Fragment() {
    private var _binding: FragmentAdminBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAdminBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val getName = getActivity()?.getIntent()?.getStringExtra(RegisterActivity.KEY_NAME)
        binding.tvLabelName.text = "Nama    : ${getName}"

    }


}

