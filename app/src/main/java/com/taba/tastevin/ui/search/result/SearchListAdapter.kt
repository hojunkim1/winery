package com.taba.tastevin.ui.search.result

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.taba.tastevin.R
import com.taba.tastevin.domain.Wine
import com.taba.tastevin.ui.detail.WineItemClickListener

class SearchListAdapter(private val clickListener: WineItemClickListener) :
    RecyclerView.Adapter<SearchListAdapter.BoardListViewHolder>() {

    private var dataset: List<Wine> = listOf()

    @SuppressLint("NotifyDataSetChanged")
    fun updateWines(newWines: List<Wine>) {
        dataset = newWines
        notifyDataSetChanged()
    }

    class BoardListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val wineImage: ImageView = view.findViewById(R.id.wine_image)
        val wineNameEn: TextView = view.findViewById(R.id.wine_name_en)
        val wineNameKr: TextView = view.findViewById(R.id.wine_name_kr)
    }


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

        Glide.with(holder.itemView.context)
            .load(item.url)
            .into(holder.wineImage)
        if (item.nameEn != null) {
            holder.wineNameEn.text = item.nameEn
            holder.wineNameKr.text = item.nameKr
        } else {
            holder.wineNameEn.text = item.nameKr
            holder.wineNameKr.text = ""
        }

        holder.itemView.setOnClickListener {
            clickListener.onWineItemClicked(item)
        }
    }

    override fun getItemCount() = dataset.size
}