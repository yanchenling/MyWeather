package com.ycl.weather.ui.place

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.ycl.weather.R
import com.ycl.weather.databinding.PlaceItemBinding
import com.ycl.weather.logic.model.Place
import com.ycl.weather.ui.weather.WeatherActivity

class PlaceAdapter(private val fragment: PlaceFragment, private val placeList: List<Place>) :
    RecyclerView.Adapter<PlaceAdapter.ViewHolder>() {


    inner class ViewHolder(binding: PlaceItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val placeName: TextView = binding.placeName
        val placeAddress: TextView = binding.placeAddress
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceAdapter.ViewHolder {
        val binding = PlaceItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = ViewHolder(binding)
        holder.itemView.setOnClickListener {
            val position = holder.adapterPosition
            val place = placeList[position + 1]
            val activity = fragment.activity
            if (activity is WeatherActivity) {
                activity.binding.drawerLayout.closeDrawers()
                activity.viewModel.locationLng = place.location.lng
                activity.viewModel.locationLat = place.location.lat
                activity.viewModel.placeName = place.name
                activity.refreshWeather()

            } else {
                val intent = Intent(parent.context, WeatherActivity::class.java).apply {
                    putExtra("location_lng", place.location.lng)
                    putExtra("location_lat", place.location.lat)
                    putExtra("place_name", place.name)
                }
                Log.e("TAG", place.location.lng + "--" + place.location.lat + "--" + place.name)
                fragment.viewModel.savePlace(place)
                fragment.startActivity(intent)
                fragment.activity?.finish()
            }
        }

        return ViewHolder(binding)
    }

    override fun getItemCount() = placeList.size

    override fun onBindViewHolder(holder: PlaceAdapter.ViewHolder, position: Int) {

        val place = placeList[position]
        holder.placeAddress.text = place.address
        holder.placeName.text = place.name
    }


}