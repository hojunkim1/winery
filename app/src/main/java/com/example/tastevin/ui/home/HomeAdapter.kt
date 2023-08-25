package com.example.tastevin.ui.home;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tastevin.R
import com.example.tastevin.domain.Wine

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    private val wines: MutableList<Wine> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_rank_list, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val wine = wines[position]//dataset[position]

        // holder의 뷰들에 wine의 데이터를 설정
        holder.itemView.findViewById<TextView>(R.id.wine_name).text = wine.nameKr
        holder.itemView.findViewById<TextView>(R.id.wine_producer).text = wine.producer


        holder.itemView.setOnClickListener {
            // 아이템 클릭 시 처리하는 로직
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // 뷰들을 findViewById로 초기화하거나 ViewBinding 사용
    }

    fun submitList(newWines: List<Wine>) {
        wines.clear()
        wines.addAll(newWines)
        notifyDataSetChanged()
    }

//    class WineDiffCallback : DiffUtil.ItemCallback<Wine>() {
//        override fun areItemsTheSame(oldItem: Wine, newItem: Wine): Boolean {
//            return oldItem.id == newItem.id
//        }
//
//        override fun areContentsTheSame(oldItem: Wine, newItem: Wine): Boolean {
//            return oldItem == newItem
//        }
//    }


    override fun getItemCount(): Int {
        return wines.size
    }
//    class BoardListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val boardTitle: TextView = view.findViewById(R.id.wine_name)
//        val boardContent: TextView = view.findViewById(R.id.wine_nation)
//    }


//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardListViewHolder {
//        val adapterLayout = LayoutInflater.from(parent.context)
//            .inflate(R.layout.item_rank_list, parent, false)
//
//        return BoardListViewHolder(adapterLayout)
//    }

    /**
     * Replace the contents of a view
     */
//    override fun onBindViewHolder(holder: BoardListViewHolder, position: Int) {
//        val item = dataset[position]
//
//        if (item.nameEn != null) {
//            holder.boardTitle.text = item.nameEn
//        } else {
//            holder.boardTitle.text = item.nameKr
//        }
//        holder.boardContent.text = item.producer
//    }

//    override fun getItemCount() = dataset.size
}


