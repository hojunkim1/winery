package com.example.winery.ui.bookmark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.winery.R
import com.example.winery.databinding.FragmentBookmarkBinding

class BookmarkFragment : Fragment() {

    private lateinit var binding: FragmentBookmarkBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bookmark, container, false)
        binding.toolbarBookmark.title = "Bookmark"
        binding.toolbarBookmark.inflateMenu(R.menu.bookmark_menu)
        binding.toolbarBookmark.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.bookmark_menu_setting -> {
                    val action =
                        BookmarkFragmentDirections.actionNavigationBookmarkToSettingFragment()
                    findNavController().navigate(action)
                    true
                }

                else -> false
            }
        }
        return binding.root
    }
}