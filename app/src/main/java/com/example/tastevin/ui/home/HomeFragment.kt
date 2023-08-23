package com.example.tastevin.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.tastevin.R
import com.example.tastevin.databinding.FragmentHomeBinding
import com.example.tastevin.ui.home.post.PostAdapter

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.toolbarHome.title = "Recommend"
        binding.toolbarHome.inflateMenu(R.menu.home_menu)
        binding.toolbarHome.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.home_menu_search -> {
                    val action = HomeFragmentDirections.actionNavigationHomeToSearchFragment()
                    findNavController().navigate(action)
                    true
                }

                R.id.home_menu_bookmark -> {
                    true
                }

                else -> false
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewPager = view.findViewById(R.id.home_post_pager)
        viewPager.adapter = PostAdapter(this)
    }
}