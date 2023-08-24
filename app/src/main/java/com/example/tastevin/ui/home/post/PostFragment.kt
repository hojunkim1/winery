package com.example.tastevin.ui.home.post

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tastevin.R
import com.example.tastevin.data.ListData
import com.example.tastevin.databinding.FragmentPostBinding
import com.example.tastevin.ui.search.result.SearchListAdapter

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

        val id = arguments?.getInt(ARG_OBJECT)

        id?.apply {
            binding.postImage.setImageResource(R.drawable.wine_image)

        }

        return binding.root
    }
    private fun openUrlInBrowser(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}