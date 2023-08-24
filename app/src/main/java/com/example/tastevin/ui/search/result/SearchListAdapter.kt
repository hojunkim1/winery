package com.example.tastevin.ui.search.result

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tastevin.R
import com.example.tastevin.data.ListData

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
            .inflate(R.layout.item_search_list_item, parent, false)

        return BoardListViewHolder(adapterLayout)
    }

    /**
     * Replace the contents of a view
     */
    override fun onBindViewHolder(holder: BoardListViewHolder, position: Int) {
        val item = dataset[position]

        if (item.nameEn != null) {
            holder.boardTitle.text = item.nameEn
        } else {
            holder.boardTitle.text = item.nameKr
        }
        holder.boardContent.text = item.producer
    }

    override fun getItemCount() = dataset.size
}