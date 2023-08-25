package com.example.tastevin.ui.search.result

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnFocusChangeListener
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.example.tastevin.MainActivity
import com.example.tastevin.R
import com.example.tastevin.databinding.FragmentSearchListBinding
import com.example.tastevin.domain.Wine
import com.example.tastevin.ui.detail.WineItemClickListener
import com.example.tastevin.ui.home.HomeViewModel
import com.example.tastevin.ui.search.SearchFragmentDirections
import com.example.tastevin.ui.search.SearchViewModel

class SearchListFragment : Fragment() {

    private lateinit var binding: FragmentSearchListBinding
    private val args: SearchListFragmentArgs by navArgs()
//    private val viewModel: SearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchListBinding.inflate(inflater)

        binding.searchTxt.hint = args.searchText

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.searchToolbar.setNavigationOnClickListener {
            val act = activity as MainActivity
            act.supportFragmentManager.popBackStack()
        }

        // 검색버튼 누르면 현재 페이지 삭제하고 다시 생성
        binding.searchToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.search_menu_search -> {
                    val searchText: String = binding.searchTxt.text.toString()
                    val action =
                        SearchListFragmentDirections.actionNavigationSearchListToSearchListFragment(searchText)
//                    findNavController().popBackStack()
                    view.findNavController().navigate(action)
                    true
                }
                else -> false
            }
        }

        binding.searchTxt.setOnKeyListener { v, keyCode, event ->
            if(event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                val searchText: String = binding.searchTxt.text.toString()
                val action = SearchListFragmentDirections.actionNavigationSearchListToSearchListFragment(searchText)
                view.findNavController().navigate(action)
            }
            true
        }

        binding.searchTxt.setOnFocusChangeListener { _, hasFocus ->
            if(hasFocus) {
                binding.searchTxt.hint = ""
            }
        }

        val searchListAdapter = SearchListAdapter(object: WineItemClickListener {
            override fun onWineItemClicked(item: Wine) {
                val bundle = Bundle().apply {
                    putParcelable("selectedWine", item)
                }
                findNavController().navigate(R.id.detail_fragment, bundle)
            }
        })

//        binding.searchListWineList.adapter = searchListAdapter
//
//        viewModel.searchWines.observe(viewLifecycleOwner, Observer { wines ->
//            searchListAdapter.updateWines(wines)
//            binding.totalCount.text = "와인 검색 결과 (${wines.size})"
//        })
//
//        binding.searchToolbar.inflateMenu(R.menu.search_menu)
        val searchWine = view.findViewById<RecyclerView>(R.id.search_list_wine_list)
        searchWine.adapter = searchListAdapter

        val viewModel = ViewModelProvider(this).get(SearchListViewModel::class.java)

        viewModel.searchWine(args.searchText)

        viewModel.searchWines.observe(viewLifecycleOwner, Observer { wines ->
            searchListAdapter.updateWines(wines)
            binding.totalCount.text = "와인 검색 결과 (${wines.size})"
        })

    }
}