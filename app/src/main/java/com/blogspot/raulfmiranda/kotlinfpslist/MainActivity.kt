package com.blogspot.raulfmiranda.kotlinfpslist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //TODO: https://youtu.be/tiXP__iYtq4?t=1468

    /**
      "https://images.pexels.com/photos/220421/pexels-photo-220421.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
      "https://images.pexels.com/photos/207891/pexels-photo-207891.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
      "https://images.pexels.com/photos/164854/pexels-photo-164854.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
      "https://images.pexels.com/photos/34533/owl-glitter-stuffed-animal-cute.jpg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
      "https://images.pexels.com/photos/60023/baboons-monkey-mammal-freeze-60023.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
    * */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = mutableListOf<Item>()
        items.addAll(listOf(
            Item("https://images.pexels.com/photos/220421/pexels-photo-220421.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260", "Imagem 1"),
            Item("https://images.pexels.com/photos/207891/pexels-photo-207891.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260", "Imagem 2"),
            Item("https://images.pexels.com/photos/164854/pexels-photo-164854.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260", "Imagem 3"),
            Item("https://images.pexels.com/photos/34533/owl-glitter-stuffed-animal-cute.jpg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260", "Imagem 4"),
            Item("https://images.pexels.com/photos/60023/baboons-monkey-mammal-freeze-60023.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260", "Imagem 5")
        ))

        recViewItems.layoutManager = LinearLayoutManager(this)
        recViewItems.adapter = ItemAdapter(items)
    }
}
