package com.example.tastevin.ui.search.result

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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

class SearchListFragment : Fragment() {

    private lateinit var binding: FragmentSearchListBinding
    private val args: SearchListFragmentArgs by navArgs()

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

        binding.searchTxt.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                binding.searchTxt.hint = ""
            }
        }

        val searchListAdapter = SearchListAdapter(object : WineItemClickListener {
            override fun onWineItemClicked(item: Wine) {
                val bundle = Bundle().apply {
                    putParcelable("selectedWine", item)
                }
                findNavController().navigate(R.id.detail_fragment, bundle)
            }
        })

//        binding.searchListWineList.adapter = searchListAdapter
        val searchWine = view.findViewById<RecyclerView>(R.id.search_list_wine_list)
        searchWine.adapter = searchListAdapter

        val viewModel = ViewModelProvider(this).get(SearchListViewModel::class.java)

        viewModel.searchWine(args.searchText, args.isOcr)

        viewModel.searchWines.observe(viewLifecycleOwner, Observer { wines ->
            searchListAdapter.updateWines(wines)
            binding.totalCount.text = "와인 검색 결과 (${wines.size})"
        })

    }
}