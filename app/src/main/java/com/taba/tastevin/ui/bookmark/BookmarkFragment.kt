package com.taba.tastevin.ui.bookmark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.taba.tastevin.R
import com.taba.tastevin.databinding.FragmentBookmarkBinding
import com.taba.tastevin.domain.Wine
import com.taba.tastevin.ui.detail.WineItemClickListener

class BookmarkFragment : Fragment() {

    private lateinit var binding: FragmentBookmarkBinding
    private val viewModel: BookmarkViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bookmark, container, false)
        binding.bookmarkToolbar.inflateMenu(R.menu.bookmark_menu)

        val layoutManager = object : LinearLayoutManager(context) {
            override fun canScrollVertically(): Boolean {
                return false
            }

            override fun canScrollHorizontally(): Boolean {
                return false
            }
        }
        binding.bookmarkList.layoutManager = layoutManager

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
        val bookmarkListAdapter = BookmarkAdapter(object : WineItemClickListener {
            override fun onWineItemClicked(item: Wine) {
                val bundle = Bundle().apply {
                    putParcelable("selectedWine", item)
                }
                findNavController().navigate(R.id.detail_fragment, bundle)
            }
        })
        binding.bookmarkList.adapter = bookmarkListAdapter

        val db = (activity?.application as com.taba.tastevin.TastevinApplication).database.wineDao()
        val list = viewModel.getWineList(db)

        bookmarkListAdapter.updateWines(list)
        binding.bookmarkCount.text = "북마크 개수 (${list.size})"
    }
}