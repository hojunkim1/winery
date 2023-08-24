package com.example.tastevin.ui.home.column

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.tastevin.MainActivity
import com.example.tastevin.R
import com.example.tastevin.databinding.FragmentColumnBinding
import com.example.tastevin.databinding.FragmentSearchBinding

class ColumnFragment : Fragment() {
    private lateinit var binding: FragmentColumnBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentColumnBinding.inflate(inflater)

        // Inflate the layout for this fragment
//        val actionBar = (requireActivity() as AppCompatActivity).supportActionBar
//        actionBar?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        return inflater.inflate(R.layout.fragment_column, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.columnToolbar.setNavigationOnClickListener {
            val act = activity as MainActivity
            act.supportFragmentManager.popBackStack()
        }
    }
}

