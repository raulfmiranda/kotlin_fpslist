package com.blogspot.raulfmiranda.kotlinfpslist

import android.content.Context
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class ItemAdapter(val _items: MutableList<Item>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    private val items = _items
    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false))
    }

    override fun getItemCount() = _items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.let {

            it.txtItem?.let {
                it.text = items[position].text
            }

            val uri = Uri.parse(items[position].url)
            Picasso
                .get()
                .load(uri.toString())
                .placeholder(R.drawable.ic_launcher_background)
                .into(it.imgItem)


        }
    }

    class ViewHolder(itemLayout: View): RecyclerView.ViewHolder(itemLayout) {
        var txtItem: TextView? = null
        var imgItem: ImageView? = null

        init {
            txtItem = itemLayout.findViewById(R.id.txtItem)
            imgItem = itemLayout.findViewById(R.id.imgItem)
        }
    }
}