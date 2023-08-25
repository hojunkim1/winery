package com.example.tastevin.ui.search

import android.os.Bundle
import android.view.KeyEvent
import android.view.KeyEvent.KEYCODE_ENTER
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
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

        binding.searchToolbar.setNavigationOnClickListener {
            val act = activity as MainActivity
            act.supportFragmentManager.popBackStack()
        }

        binding.searchToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.search_menu_search -> {
                    val searchText: String = binding.searchTxt.text.toString()
                    val action =
                        SearchFragmentDirections.actionNavigationSearchFragmentToSearchListFragment(searchText)
                    view.findNavController().navigate(action)
                    true
                }

                else -> false
            }
        }

        binding.searchTxt.setOnKeyListener { v, keyCode, event ->
            if(event.action == KeyEvent.ACTION_DOWN && keyCode == KEYCODE_ENTER) {
                        val searchText: String = binding.searchTxt.text.toString()
                        val action = SearchFragmentDirections.actionNavigationSearchFragmentToSearchListFragment(searchText)
                        view.findNavController().navigate(action)
            }
            true
        }

        binding.searchOcrButton.setOnClickListener {
            val action = SearchFragmentDirections.actionNavigationSearchToCameraFragment()
            view.findNavController().navigate(action)
        }
    }
}