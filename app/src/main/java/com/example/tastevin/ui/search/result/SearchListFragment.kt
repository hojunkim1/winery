package com.example.tastevin.ui.search.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tastevin.MainActivity
import com.example.tastevin.databinding.FragmentSearchListBinding

class SearchListFragment : Fragment() {

    private lateinit var binding: FragmentSearchListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchListBinding.inflate(inflater)
        binding.searchListWineList.adapter = SearchListAdapter()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.searchToolbar.setNavigationOnClickListener {
            val act = activity as MainActivity
            act.supportFragmentManager.popBackStack()
        }
    }
}