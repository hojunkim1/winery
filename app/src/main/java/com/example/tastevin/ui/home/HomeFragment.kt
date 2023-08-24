package com.example.tastevin.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.tastevin.MainActivity
import com.example.tastevin.R
import com.example.tastevin.databinding.FragmentHomeBinding
import com.example.tastevin.ui.home.post.PostAdapter

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewPager: ViewPager2

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        // layout manager
        val recyclerView = binding.rankWine
        val spanCount = 3 // 한 줄에 표시될 아이템 개수
        val layoutManager = GridLayoutManager(requireContext(), spanCount, RecyclerView.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager

        //binding = FragmentHomeBinding.inflate(inflater)
        binding.homeToolbar.title = "tastevin"

        binding.homeToolbar.inflateMenu(R.menu.home_menu)
        binding.rankWine.adapter = HomeAdapter()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.homeViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.homeToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.home_menu_search -> {
                    val action = HomeFragmentDirections.actionNavigationHomeToSearchFragment()
                    view.findNavController().navigate(action)
                    true
                }

                else -> false
            }
        }

        viewPager = view.findViewById(R.id.home_post_pager)
        viewPager.adapter = PostAdapter(this)
    }
}