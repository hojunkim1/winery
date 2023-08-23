package com.example.winery.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.winery.MainActivity
import com.example.winery.R
import com.example.winery.databinding.FragmentSearchBinding
import com.example.winery.network.WineApi
import com.example.winery.ui.search.result.SearchListAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var searchEditText: EditText
    private var savedEditTextContent: String? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater)
        //binding.toolbarSearch.title = "Search"
        binding.toolbarSearch.inflateMenu(R.menu.search_menu)
        binding.toolbarSearch.setNavigationOnClickListener {
            val act = activity as MainActivity
            act.supportFragmentManager.popBackStack()
        }

        binding.toolbarSearch.setOnMenuItemClickListener{
            when (it.itemId) {
                R.id.search_menu_search -> {
                    val action = SearchFragmentDirections.actionNavigationSearchFragmentToSearchListFragment()
                    findNavController().navigate(action)
                    true
                }
                else -> false
            }
        }


        binding.cameraButton.setOnClickListener {
            val action = SearchFragmentDirections.actionNavigationSearchToCameraFragment()
            findNavController().navigate(action)
        }


        return binding.root
    }
}