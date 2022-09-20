package com.example.project2wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishListAdapter (private val items: List<WishList>) : RecyclerView.Adapter<WishListAdapter.ViewHolder>() {
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // TODO: Create member variables for any view that will be set
        // as you render a row.
        var itemTextView: TextView
        var priceTextView: TextView
        var urlTextView: TextView
        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            // TODO: Store each of the layout's views into
            // the public final member variables created above
            itemTextView = itemView.findViewById(R.id.item)
            priceTextView = itemView.findViewById(R.id.price)
            urlTextView = itemView.findViewById(R.id.url)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var context = parent.context
        var inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        var contactView = inflater.inflate(R.layout.list_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        var itemList = items.get(position)
        // Set item views based on views and data model
        holder.itemTextView.text = itemList.itemName
        holder.priceTextView.text = itemList.price
        holder.urlTextView.text = itemList.url
    }

    override fun getItemCount(): Int {
        return items.size
    }
}