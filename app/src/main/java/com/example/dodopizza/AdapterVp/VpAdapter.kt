package com.example.dodopizza.AdapterVp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dodopizza.R

class VpAdapter(val context: Context,val list:ArrayList<MyDataGuid>): RecyclerView.Adapter<VpAdapter.MyVH>() {
    class MyVH(itemView: View): RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.guid_im)
        val title: TextView = itemView.findViewById(R.id.guid_title)
        val descr: TextView = itemView.findViewById(R.id.guid_descr)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVH {
        val root = LayoutInflater.from(context).inflate(R.layout.vp_adapter,parent,false)
        return MyVH(root)
    }

    override fun onBindViewHolder(holder: MyVH, position: Int) {
        holder.title.text = list[position].title
        holder.descr.text = list[position].descr
        holder.image.setImageResource(list[position].image)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}