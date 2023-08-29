package com.example.tastevin.ui.search
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.example.tastevin.R
//import com.example.tastevin.network.NetworkWine
//
//class SearchAdapter(private val listener: OnItemClickListener) :
//    RecyclerView.Adapter<SearchAdapter.ViewHolder>() {
//
//    private val items: MutableList<NetworkWine> = mutableListOf()
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val itemView = LayoutInflater.from(parent.context)
//            .inflate(R.layout.item_search_list_item, parent, false)
//        return ViewHolder(itemView)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val wine = items[position]
//
//        // holder의 뷰들에 wine의 데이터를 설정
//        holder.itemView.findViewById<TextView>(R.id.wine_name_en).text = wine.nameKr
//        holder.itemView.findViewById<TextView>(R.id.wine_name_kr).text = wine.producer
//
//        holder.itemView.setOnClickListener {
//            listener.onItemClick(wine)
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return items.size
//    }
//
//    fun submitList(newList: List<NetworkWine>) {
//        items.clear()
//        items.addAll(newList)
//        notifyDataSetChanged()
//    }
//
//    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
//
//    interface OnItemClickListener {
//        fun onItemClick(wine: NetworkWine)
//    }
//}
