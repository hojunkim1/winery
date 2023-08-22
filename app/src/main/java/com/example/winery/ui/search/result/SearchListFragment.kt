package com.example.winery.ui.search.result

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.winery.MainActivity
import com.example.winery.R
import com.example.winery.databinding.FragmentSearchListBinding
import com.example.winery.databinding.FragmentSettingBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SearchListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding: FragmentSearchListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchListBinding.inflate(inflater)
        binding.toolbarSearch.title = "Result"
        binding.wineList.adapter = SearchListAdapter()
        binding.toolbarSearch.setNavigationOnClickListener {
            val act = activity as MainActivity
            act.supportFragmentManager.popBackStack()
        }
        return binding.root
    }



}