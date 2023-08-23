package com.example.winery.ui.search.result

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.winery.MainActivity
import com.example.winery.R
import com.example.winery.databinding.FragmentSearchListBinding
import com.example.winery.databinding.FragmentSettingBinding
import com.example.winery.ui.search.SearchViewModel


class SearchListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding: FragmentSearchListBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchListBinding.inflate(inflater)
        //binding.toolbarSearch.title = "Result"
        binding.wineList.adapter = SearchListAdapter()
        binding.toolbarSearch.setNavigationOnClickListener {
            val act = activity as MainActivity
            act.supportFragmentManager.popBackStack()
        }

        return binding.root
    }



}