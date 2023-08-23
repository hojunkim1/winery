package com.example.tastevin.ui.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tastevin.MainActivity
import com.example.tastevin.databinding.FragmentSettingBinding

class SettingFragment : Fragment() {

    private lateinit var binding: FragmentSettingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingBinding.inflate(inflater)
        binding.settingToolbar.title = "Setting"
        binding.settingToolbar.setNavigationOnClickListener {
            val act = activity as MainActivity
            act.supportFragmentManager.popBackStack()
        }
        return binding.root
    }
}