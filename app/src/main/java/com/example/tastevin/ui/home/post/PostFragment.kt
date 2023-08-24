package com.example.tastevin.ui.home.post

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tastevin.R
import com.example.tastevin.data.ListData
import com.example.tastevin.databinding.FragmentPostBinding

class PostFragment : Fragment() {

    companion object {
        const val ARG_OBJECT = "object"
    }

    private lateinit var binding: FragmentPostBinding

    private val dataset = ListData.newBoard

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPostBinding.inflate(inflater, container, false)
        val id = arguments?.getInt(ARG_OBJECT)

        id?.apply {
            binding.postImage.setImageResource(R.drawable.wine_image)
            if (dataset[id - 1].nameEn != null) {
                binding.postTitle.text = dataset[id - 1].nameEn
            } else {
                binding.postTitle.text = dataset[id - 1].nameKr
            }
            binding.postSubtitle.text = dataset[id - 1].producer
        }

        return binding.root
    }
}