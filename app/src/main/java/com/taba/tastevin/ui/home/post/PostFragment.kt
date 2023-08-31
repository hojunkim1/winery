package com.taba.tastevin.ui.home.post

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.taba.tastevin.R
import com.taba.tastevin.databinding.FragmentPostBinding
import com.taba.tastevin.ui.home.HomeFragmentDirections

class PostFragment : Fragment() {

    companion object {
        const val ARG_OBJECT = "object"
    }

    private lateinit var binding: FragmentPostBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPostBinding.inflate(inflater, container, false)

        binding.postImage.setOnClickListener {
            val action =
                HomeFragmentDirections.actionNavigationHomeToColumnFragment()
            findNavController().navigate(action)

        }
        val id = arguments?.getInt(ARG_OBJECT)

        id?.let {
            val imageResId = when (it) {
                1 -> R.drawable.column1
                2 -> R.drawable.column2
                3 -> R.drawable.column3
                else -> R.drawable.column1
            }
            binding.postImage.setImageResource(imageResId)
        }

        return binding.root
    }
}