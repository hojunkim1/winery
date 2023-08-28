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

//        // TODO 추천 와인 서버 연결 필요
//        binding.recommendWineList.adapter =
//            RecommendWineListAdapter(object : WineItemClickListener {
//                override fun onWineItemClicked(item: Wine) {
//                    val bundle = Bundle().apply {
//                        putParcelable("selectedWine", item)
//                    }
//                    findNavController().navigate(R.id.detail_fragment, bundle)
//                }
//            })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.toolbar.setNavigationOnClickListener {
            val act = activity as MainActivity
            act.supportFragmentManager.popBackStack()
        }

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

        binding.typeText.text = item.type
        binding.sweetNum.text = item.sweet.toString()
        binding.acidityNum.text = item.acidity.toString()
        binding.bodyNum.text = item.body.toString()
        binding.tanninNum.text = item.tannin.toString()

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
    }
}