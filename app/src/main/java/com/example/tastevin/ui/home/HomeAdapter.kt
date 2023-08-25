package com.example.tastevin.ui.home;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tastevin.R
import com.example.tastevin.domain.Wine
import com.example.tastevin.ui.detail.WineItemClickListener

class HomeAdapter(private val clickListener: WineItemClickListener) :
    RecyclerView.Adapter<HomeAdapter.BoardListViewHolder>() {
    private var dataset: List<Wine> = listOf()

    fun updateWines(newWines: List<Wine>) {
        dataset = newWines
        notifyDataSetChanged()
    }

    class BoardListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val wineImage: ImageView = view.findViewById(R.id.wine_image)
        val wineName: TextView = view.findViewById(R.id.wine_name)
        val wineProducer: TextView = view.findViewById(R.id.wine_producer)
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

        Glide.with(holder.itemView.context)
            .load(item.url)
            .into(holder.wineImage)
        if (item.nameEn != null) {
            holder.wineName.text = item.nameEn
        } else {
            holder.wineName.text = item.nameKr
        }
        holder.wineProducer.text = item.producer

        holder.itemView.setOnClickListener {
            clickListener.onWineItemClicked(item)
        }
    }

    override fun getItemCount() = dataset.size
}


