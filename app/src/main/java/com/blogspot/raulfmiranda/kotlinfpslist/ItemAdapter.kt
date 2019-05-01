package com.blogspot.raulfmiranda.kotlinfpslist

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ItemAdapter(private val items: MutableList<Item>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.let {

            it.txtItem?.let {
                it.text = items[position].text
            }

            val url = items[position].url
            val uri = Uri.parse(url)
            val img = it.imgItem

            Picasso
                .get()
                .load(uri.toString()).fit()
                .error(R.drawable.ic_launcher_foreground)
                .into(img)
        }
    }

    class ViewHolder(itemLayout: View): RecyclerView.ViewHolder(itemLayout) {
        var txtItem: TextView? = null
        var imgItem: ImageView? = null

        init {
            txtItem = itemLayout.findViewById(R.id.txtItem)
            imgItem = itemLayout.findViewById(R.id.imgItem)

            itemLayout.setOnClickListener {
                val context = itemLayout.context
                val intent = Intent(context, HomeActivity::class.java)
                context.startActivity(intent)
            }
        }
    }
}