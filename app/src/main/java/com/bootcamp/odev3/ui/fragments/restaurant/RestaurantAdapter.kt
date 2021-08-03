package com.bootcamp.odev3.ui.fragments.restaurant

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.odev3.R
import com.bootcamp.odev3.models.core.Restaurant
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

class RestaurantAdapter: RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {

    var list = ArrayList<Restaurant>()

    class RestaurantViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        private val restaurantLogo:ImageView=item.findViewById(R.id.restaurantImageView)
        private val restaurantNameTextView:TextView=item.findViewById(R.id.restaurantName_TextView)
        private val restaurantAddress:TextView=item.findViewById(R.id.restaurantAddress_textView)
        fun bind(restaurant: Restaurant){

            Log.d("resIMGG",restaurant.logoUrl)


            restaurantNameTextView.text=restaurant.name
            restaurantAddress.text=restaurant.typeOfRestaurant
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val viewItem =
            LayoutInflater.from(parent.context).inflate(R.layout.restaurant_row_item, parent, false)
        return RestaurantViewHolder(viewItem)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int =list.size

    fun setRestaurantData(list: List<Restaurant>) {
        this.list = ArrayList(list)
        notifyDataSetChanged()
    }
    fun insertRestaurantData(list: List<Restaurant>) {
        val listIndex = this.list.size
        this.list.addAll(ArrayList(list))
        notifyItemInserted(listIndex)
    }
}