package com.example.tastevin.ui.bookmark

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

class BookmarkAdapter(private val clickListener: WineItemClickListener) :
    RecyclerView.Adapter<BookmarkAdapter.BookmarkViewHolder>() {

    private var dataset: List<Wine> = listOf()

    fun updateWines(newWines: List<Wine>) {
        dataset = newWines
        notifyDataSetChanged()
    }

    /**
     * Initialize view elements
     */
    class BookmarkViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val wineImage: ImageView = view.findViewById(R.id.wine_image)
        val wineName: TextView = view.findViewById(R.id.wine_name)
        val wineProducer: TextView = view.findViewById(R.id.wine_producer)
    }

    /**
     * Create new views
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_search_list_item, parent, false)

        return BookmarkViewHolder(adapterLayout)
    }

    /**
     * Replace the contents of a view
     */
    override fun onBindViewHolder(holder: BookmarkViewHolder, position: Int) {
        val item = dataset[position]

        // image URL로 받아오기
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

    override fun getItemCount(): Int {
        return dataset.size
    }
}