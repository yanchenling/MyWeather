package com.ycl.weather.ui.place

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.ycl.weather.R
import com.ycl.weather.databinding.PlaceItemBinding
import com.ycl.weather.logic.model.Place

class PlaceAdapter(private val fragment: Fragment,private val placeList: List<Place>) : RecyclerView.Adapter<PlaceAdapter.ViewHolder>(){


    inner class ViewHolder(binding: PlaceItemBinding) : RecyclerView.ViewHolder(binding.root){
        val placeName: TextView = binding.placeName
        val placeAddress: TextView = binding.placeAddress
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceAdapter.ViewHolder {
        val binding = PlaceItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount()=placeList.size

    override fun onBindViewHolder(holder: PlaceAdapter.ViewHolder, position: Int) {

        val place = placeList.get(position)
        holder.placeAddress.text=place.address
        holder.placeName.text=place.name
    }


}