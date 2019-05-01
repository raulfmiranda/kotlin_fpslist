package com.blogspot.raulfmiranda.kotlinfpslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import android.widget.AbsListView
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val items = mutableListOf<Item>()
    val adapter = ItemAdapter(items)

    private val urlImgs = arrayOf(
        "https://images.pexels.com/photos/220421/pexels-photo-220421.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
        "https://images.pexels.com/photos/207891/pexels-photo-207891.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
        "https://images.pexels.com/photos/164854/pexels-photo-164854.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
        "https://images.pexels.com/photos/34533/owl-glitter-stuffed-animal-cute.jpg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
        "https://images.pexels.com/photos/60023/baboons-monkey-mammal-freeze-60023.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
    )

    private var isScrolling = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addItems();

        val manager = androidx.recyclerview.widget.LinearLayoutManager(this)

        recViewItems.layoutManager = manager
        recViewItems.adapter = adapter

        recViewItems.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: androidx.recyclerview.widget.RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if(newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL)
                    isScrolling = true
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val currentItems = manager.childCount
                val totalItems = manager.itemCount
                val scrollOutItems = manager.findFirstVisibleItemPosition()

                if(isScrolling && (currentItems + scrollOutItems == totalItems)){
                    isScrolling = false
                    addItems()
                }
            }
        })


    }

    private fun addItems() {

        for (i in 0..20) {
            items.add(Item(urlImgs[i % 5], "Imagem ${items.size + 1}"))
        }

        adapter.notifyDataSetChanged()

    }
}
