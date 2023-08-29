package com.example.tastevin.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tastevin.MainActivity
import com.example.tastevin.R
import com.example.tastevin.data.ListData
import com.example.tastevin.databinding.FragmentDetailBinding
import com.example.tastevin.domain.Wine

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val dataset = ListData.newBoard

    private var bookmarked: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater)

        val layoutManager = object : LinearLayoutManager(context) {
            override fun canScrollVertically(): Boolean {
                return false
            }

            override fun canScrollHorizontally(): Boolean {
                return false
            }
        }
        binding.recommendWineList.layoutManager = layoutManager

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.toolbar.setNavigationOnClickListener {
            val act = activity as MainActivity
            act.supportFragmentManager.popBackStack()
        }

//        val item = dataset[0]
        val item = arguments?.getParcelable<Wine>("selectedWine") ?: dataset[0]

        Glide.with(binding.wineImage)
            .load(item.url)
            .into(binding.wineImage)
        if (item.nameEn != null) {
            binding.enWineNameText.text = item.nameEn
            binding.koWineNameText.text = item.nameKr
        } else {
            binding.enWineNameText.text = item.nameKr
            binding.koWineNameText.text = ""
        }
        binding.producerText.text = item.producer
        binding.nationText.text = item.nation

        // TODO typeText 레이아웃 추가
//        binding.typeText.text = item.type
        var sweetNum = item.sweet.toString()
        val sweetRating = item.sweet.toFloat() // Convert the value to float for the rating
        binding.ratingSweet.rating = sweetRating

        var acidityNum = item.acidity.toString()
        binding.ratingAcidity.rating = item.acidity.toFloat()

        var bodyNum = item.body.toString()
        binding.ratingBody.rating = item.body.toFloat()

        var tanninNum = item.body.toString()
        binding.ratingTannin.rating = item.tannin.toFloat()

        binding.priceText.text = item.price
        binding.foodListText.text = item.food


        val recommendListAdapter = RecommendWineListAdapter(object : WineItemClickListener {
            override fun onWineItemClicked(item: Wine) {
                val bundle = Bundle().apply {
                    putParcelable("selectedWine", item)
                }
                findNavController().navigate(R.id.detail_fragment, bundle)
            }
        })
        binding.recommendWineList.adapter = recommendListAdapter

        val recommendWine = view.findViewById<RecyclerView>(R.id.recommend_wine_list)
        recommendWine.adapter = recommendListAdapter

        val viewModel = ViewModelProvider(this)[DetailViewModel::class.java]

        viewModel.recommendWine(item)
        viewModel.recommendWines.observe(viewLifecycleOwner, Observer { wines ->
            recommendListAdapter.updateWines(wines)
        })

        // 북마크 버튼 초기화
//        bookmarked = viewModel.isBookmarked(item.id)
        bookmarked = false
        if (bookmarked) {
            binding.bookmarkButton.setImageResource(R.drawable.bookmark_filled)
        } else {
            binding.bookmarkButton.setImageResource(R.drawable.bookmark_gold)
        }

        // 북마크 버튼 클릭 시
        // 1. 북마크에 존재 -> 북마크 제거
        // 2. 북마크에 존재 X -> 북마크 추가
        binding.bookmarkButton.setOnClickListener {
            if (bookmarked) {
                viewModel.deleteToBookmarkList(item)
                bookmarked = false
            } else {
                viewModel.addToBookmarkList(item)
                bookmarked = true
            }
        }
    }
}