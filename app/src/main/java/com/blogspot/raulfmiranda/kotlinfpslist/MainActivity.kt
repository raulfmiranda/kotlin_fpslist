package com.blogspot.raulfmiranda.kotlinfpslist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = mutableListOf<Item>()
        val urlImgs = arrayOf(
            "https://images.pexels.com/photos/220421/pexels-photo-220421.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
            "https://images.pexels.com/photos/207891/pexels-photo-207891.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
            "https://images.pexels.com/photos/164854/pexels-photo-164854.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
            "https://images.pexels.com/photos/34533/owl-glitter-stuffed-animal-cute.jpg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
            "https://images.pexels.com/photos/60023/baboons-monkey-mammal-freeze-60023.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
        )

        for (i in 0..1000) {
            items.add(i, Item(urlImgs[i % 5], "Imagem ${i + 1}"))
        }

        recViewItems.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
            }
        });

        recViewItems.layoutManager = LinearLayoutManager(this)
        recViewItems.adapter = ItemAdapter(items)
    }
}
