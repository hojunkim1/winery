package com.example.tastevin.ui.search

import android.os.Bundle
import android.view.KeyEvent
import android.view.KeyEvent.KEYCODE_ENTER
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.tastevin.MainActivity
import com.example.tastevin.R
import com.example.tastevin.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater)
        binding.searchToolbar.inflateMenu(R.menu.search_menu)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        var searchText: String

//        val viewModel = ViewModelProvider(this).get(SearchViewModel::class.java)
//        viewModel.searchWines.observe(viewLifecycleOwner, Observer { wines ->
////            wineAdapter.updateWines(wines)
//        })

        binding.searchToolbar.setNavigationOnClickListener {
            val act = activity as MainActivity
            act.supportFragmentManager.popBackStack()
        }

        binding.searchToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.search_menu_search -> {
                    val searchText = binding.searchTxt.text.toString()
//                    viewModel.searchWine(searchText)
                    val action =
                        SearchFragmentDirections.actionNavigationSearchFragmentToSearchListFragment(
                            searchText,
                            "0"
                        )
                    view.findNavController().navigate(action)
                    true
                }
                else -> false
            }
        }

        binding.searchTxt.setOnKeyListener { _, keyCode, event ->
            if(event.action == KeyEvent.ACTION_DOWN && keyCode == KEYCODE_ENTER) {
                val searchText = binding.searchTxt.text.toString()
//                viewModel.searchWine(searchText)
                val action =
                    SearchFragmentDirections.actionNavigationSearchFragmentToSearchListFragment(
                        searchText,
                        "0"
                    )
                view.findNavController().navigate(action)
                true
            } else {
                false
            }
        }

        binding.searchOcrButton.setOnClickListener {
            val action = SearchFragmentDirections.actionNavigationSearchToCameraFragment()
            view.findNavController().navigate(action)
        }
    }
}