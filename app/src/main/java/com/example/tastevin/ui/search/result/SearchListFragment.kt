package com.example.tastevin.ui.search.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.tastevin.MainActivity
import com.example.tastevin.R
import com.example.tastevin.databinding.FragmentSearchListBinding
import com.example.tastevin.ui.search.SearchFragmentDirections

class SearchListFragment : Fragment() {

    private lateinit var binding: FragmentSearchListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchListBinding.inflate(inflater)
        binding.searchToolbar.inflateMenu(R.menu.search_menu)
        binding.searchListWineList.adapter = SearchListAdapter()
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
                    val action =
                        SearchFragmentDirections.actionNavigationSearchFragmentToSearchListFragment()
                    findNavController().popBackStack()
                    view.findNavController().navigate(action)
                    true
                }

                else -> false
            }
        }
    }

}