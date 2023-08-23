package com.example.tastevin.ui.bookmark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.tastevin.R
import com.example.tastevin.databinding.FragmentBookmarkBinding

class BookmarkFragment : Fragment() {

    private lateinit var binding: FragmentBookmarkBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bookmark, container, false)
        binding.bookmarkToolbar.title = "Bookmark"
        binding.bookmarkToolbar.inflateMenu(R.menu.bookmark_menu)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.bookmarkToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.bookmark_menu_setting -> {
                    val action =
                        BookmarkFragmentDirections.actionNavigationBookmarkToSettingFragment()
                    view.findNavController().navigate(action)
                    true
                }

                else -> false
            }
        }
    }
}