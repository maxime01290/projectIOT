package com.example.projectiot.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projectiot.Model.Bulb
import com.example.projectiot.R

class AdapterBulb(context: Context, list:List<Bulb>,onItemClickListener: onItemClickListenerCustom):
        RecyclerView.Adapter<AdapterBulb.MyVH>() {

    var list: List<Bulb>
    var context: Context
    var onItemClickListener: onItemClickListenerCustom


    interface onItemClickListenerCustom {
        fun onItemClick(position: Int)
    }

    init {
        this.list = list
        this.context = context
        this.onItemClickListener = onItemClickListener
    }
    class MyVH(view: View,onItemClickListener: onItemClickListenerCustom) :
            RecyclerView.ViewHolder(view), View.OnClickListener{
        var tv1: TextView
        var iv1:ImageView
        var iv2:ImageView
        var isSelected: Boolean
        var onItemClickListener: onItemClickListenerCustom

        init {
            isSelected = false
            tv1 = view.findViewById(R.id.textView_bulb)
            iv1 = view.findViewById(R.id.imageView_bulb)
            iv2 = view.findViewById(R.id.imageView_big_bulb)
            this.onItemClickListener = onItemClickListener
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            onItemClickListener.onItemClick(adapterPosition)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVH {
        val context = parent.context
        val layout: View = LayoutInflater.from(context)
                .inflate(R.layout.item_layout_bulb, parent, false)
        return MyVH(layout,onItemClickListener)
    }

    override fun onBindViewHolder(holder: MyVH, position: Int) {
        holder.tv1.setText("${list[position].name.toUpperCase()}")
        if(list[position].isSelected == true){
            holder.iv1.setImageResource(android.R.drawable.btn_star_big_on)
        }else{
            holder.iv1.setImageResource(android.R.drawable.btn_star_big_off)
        }
        holder.iv2.setImageResource(list[position].urlImage)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}