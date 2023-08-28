package com.example.tastevin.ui.home.column

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tastevin.MainActivity
import com.example.tastevin.databinding.FragmentColumnBinding

class ColumnFragment : Fragment() {
    private lateinit var binding: FragmentColumnBinding

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//        }
//    }

    companion object {
        private const val READ_EXTERNAL_STORAGE_PERMISSION_CODE = 1
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentColumnBinding.inflate(inflater)

        // Inflate the layout for this fragment
//        val actionBar = (requireActivity() as AppCompatActivity).supportActionBar
//        actionBar?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.columnToolbar.setNavigationOnClickListener {
            val act = activity as MainActivity
            act.supportFragmentManager.popBackStack()
        }
    }


}

