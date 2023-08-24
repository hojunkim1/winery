package com.example.tastevin.ui.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tastevin.R
import com.example.tastevin.data.ListData

class RecommendWineListAdapter :
    RecyclerView.Adapter<RecommendWineListAdapter.RecommendWineListViewHolder>() {
    private val dataset = ListData.newBoard

    /**
     * Initialize view elements
     */
    class RecommendWineListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val wineImage: ImageView = view.findViewById(R.id.wine_image)
        val wineName: TextView = view.findViewById(R.id.wine_name)
        val wineProducer: TextView = view.findViewById(R.id.wine_producer)
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
        val item = dataset[position]

        // image URL로 받아오기
//        holder.wineImage.
        if (item.nameEn != null) {
            holder.wineName.text = item.nameEn
        } else {
            holder.wineName.text = item.nameKr
        }
        holder.wineProducer.text = item.producer

        holder.itemView.setOnClickListener {

        }
    }

    override fun getItemCount() = dataset.size
}