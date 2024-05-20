package com.example.homework4recyclerpart2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homework4recyclerpart2.OnItemClick
import com.example.homework4recyclerpart2.R
import com.example.homework4recyclerpart2.data.ContinentEntity

class MainAdapter(
    private val data: ArrayList<ContinentEntity>,
    private val onItemClick: OnItemClick
) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_continent, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.onBind(data[position])
        holder.itemView.setOnClickListener {
            onItemClick.onItemClick(data[position])
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val continentIv: ImageView = itemView.findViewById(R.id.country_iv)
        private val continentNameTv: TextView = itemView.findViewById(R.id.continent_name_tv)

        fun onBind(continent: ContinentEntity) {
            Glide.with(continentIv).load(continent.continentPhoto).into(continentIv)
            continentNameTv.text = continent.continentName
        }
    }
}