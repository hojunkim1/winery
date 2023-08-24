package com.example.tastevin.ui.home;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tastevin.R
import com.example.tastevin.data.ListData

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.BoardListViewHolder>() {
    private val dataset = ListData.newBoard

    class BoardListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val boardTitle: TextView = view.findViewById(R.id.wine_name)
        val boardContent: TextView = view.findViewById(R.id.wine_nation)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardListViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_rank_list, parent, false)

        return BoardListViewHolder(adapterLayout)
    }

    /**
     * Replace the contents of a view
     */
    override fun onBindViewHolder(holder: BoardListViewHolder, position: Int) {
        val item = dataset[position]

        holder.boardTitle.text = item.name
        holder.boardContent.text = item.nation
    }

    override fun getItemCount() = 4
}


