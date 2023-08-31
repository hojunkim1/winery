package com.taba.tastevin.ui.home.column

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.taba.tastevin.databinding.FragmentColumnBinding

class ColumnFragment : Fragment() {
    private lateinit var binding: FragmentColumnBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentColumnBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.columnToolbar.setNavigationOnClickListener {
            val act = activity as com.taba.tastevin.MainActivity
            act.supportFragmentManager.popBackStack()
        }
    }
}