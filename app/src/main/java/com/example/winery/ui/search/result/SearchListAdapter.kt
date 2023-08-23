package com.example.winery.ui.search.result

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.winery.R
import com.example.winery.data.ListData

class SearchListAdapter : RecyclerView.Adapter<SearchListAdapter.BoardListViewHolder>() {
    private val dataset = ListData.newBoard

    /**
     * Initialize view elements
     */
    class BoardListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val boardTitle: TextView = view.findViewById(R.id.wine_name)
        val boardContent: TextView = view.findViewById(R.id.wine_nation)
    }

    /**
     * Create new views
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardListViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.search_list_item, parent, false)

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

    override fun getItemCount() = dataset.size
}