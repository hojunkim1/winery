package com.example.tastevin.ui.bookmark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.tastevin.R
import com.example.tastevin.databinding.FragmentBookmarkBinding
import com.example.tastevin.domain.Wine
import com.example.tastevin.ui.detail.WineItemClickListener
import com.example.tastevin.ui.search.result.SearchListAdapter

class BookmarkFragment : Fragment() {

    private lateinit var binding: FragmentBookmarkBinding
    private val viewModel: BookmarkViewModel by viewModels()

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

        // 북마크 아이템 클릭 리스너
        val bookmarkListAdapter = BookmarkAdapter(object: WineItemClickListener{
            override fun onWineItemClicked(item: Wine) {
                val bundle = Bundle().apply {
                    putParcelable("selectedWine", item)
                }
                findNavController().navigate(R.id.detail_fragment, bundle)
            }
        })
        binding.bookmarkList.adapter = bookmarkListAdapter


        // 북마크 리스트 DB 불러오기
        val viewModel = ViewModelProvider(this).get(BookmarkViewModel::class.java)

        bookmarkListAdapter.updateWines(viewModel.list)
    }
}