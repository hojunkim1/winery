package com.taba.tastevin.ui.home.post

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class PostAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun createFragment(position: Int): Fragment {
        val fragment = PostFragment()
        fragment.arguments = Bundle().apply {
            putInt(PostFragment.ARG_OBJECT, position + 1)
        }
        return fragment
    }

    override fun getItemCount() = 3
}