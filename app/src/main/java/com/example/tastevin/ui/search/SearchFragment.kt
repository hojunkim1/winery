package com.example.tastevin.ui.search

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.KeyEvent.KEYCODE_ENTER
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.tastevin.MainActivity
import com.example.tastevin.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.searchToolbar.setNavigationOnClickListener {
            val act = activity as MainActivity
            act.supportFragmentManager.popBackStack()
        }

        binding.searchButton.setOnClickListener {
            val searchText = binding.searchTxt.text.toString()
            if (searchText != "") { // 입력이 없을 경우 검색 X
                val action =
                    SearchFragmentDirections.actionNavigationSearchFragmentToSearchListFragment(
                        searchText,
                        "0"
                    )
                view.findNavController().navigate(action)
            }
        }

        binding.searchTxt.setOnKeyListener { _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KEYCODE_ENTER) {
                val searchText = binding.searchTxt.text.toString()
                searchByText(searchText)
                true
            } else {
                false
            }
        }

        binding.searchOcrButton.setOnClickListener {
            val action = SearchFragmentDirections.actionNavigationSearchToCameraFragment()
            view.findNavController().navigate(action)
        }

        // 키워드 클릭 시 해당 키워드로 와인 검색
        val wineKeyword1 = binding.keyword1
        wineKeyword1.setOnClickListener { searchByText(wineKeyword1.text.toString()) }
        val wineKeyword2 = binding.keyword2
        wineKeyword2.setOnClickListener { searchByText(wineKeyword2.text.toString()) }
        val wineKeyword3 = binding.keyword3
        wineKeyword3.setOnClickListener { searchByText(wineKeyword3.text.toString()) }
        val wineKeyword4 = binding.keyword4
        wineKeyword4.setOnClickListener { searchByText(wineKeyword4.text.toString()) }
        val wineKeyword5 = binding.keyword5
        wineKeyword5.setOnClickListener { searchByText(wineKeyword5.text.toString()) }
    }

    /**
     * text를 받아 SearchListFragment로 전달하며 SearchListFragment를 띄우는 함수
     */
    private fun searchByText(text: String) {
        val action =
            SearchFragmentDirections.actionNavigationSearchFragmentToSearchListFragment(
                text,
                "0"
            )
        findNavController().navigate(action)
    }
}