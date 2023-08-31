package com.taba.tastevin.ui.detail

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

interface WineItemClickListener {
    fun onWineItemClicked(item: Wine)
}

class RecommendWineListAdapter(private val clickListener: WineItemClickListener) :
    RecyclerView.Adapter<RecommendWineListAdapter.RecommendWineListViewHolder>() {
    private var dataset: List<Wine> = listOf()

    @SuppressLint("NotifyDataSetChanged")
    fun updateWines(newWines: List<Wine>) {
        dataset = newWines
        notifyDataSetChanged()
    }

    /**
     * Initialize view elements
     */
    class RecommendWineListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val wineImage: ImageView = view.findViewById(R.id.wine_image)
        val wineNameEn: TextView = view.findViewById(R.id.wine_name_en)
        val wineNameKr: TextView = view.findViewById(R.id.wine_name_kr)
    }

    /**
     * Create new views
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendWineListViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recommend_wine_item, parent, false)

        return RecommendWineListViewHolder(adapterLayout)
    }

    /**
     * Replace the contents of a view
     */
    override fun onBindViewHolder(holder: RecommendWineListViewHolder, position: Int) {
        if (position < dataset.size) {
            val item = dataset[position]

            // image URL로 받아오기
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
    }

    override fun getItemCount() = 3
}