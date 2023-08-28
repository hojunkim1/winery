package com.example.tastevin.ui.bookmark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.tastevin.R
import com.example.tastevin.databinding.FragmentBookmarkBinding
import com.example.tastevin.domain.Wine
import com.example.tastevin.ui.detail.WineItemClickListener
import com.example.tastevin.ui.search.result.SearchListAdapter
import com.example.tastevin.ui.search.result.SearchListViewModel

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

        // TODO 북마크 리스트 연결 구현 필요
    }
}