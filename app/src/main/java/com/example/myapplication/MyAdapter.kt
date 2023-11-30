package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

class MyAdapter(var list: List<Pizza>) : RecyclerView.Adapter<MyAdapter.MyItemView>() {

    class MyItemView(v: View) : RecyclerView.ViewHolder(v) {
        val name : TextView = v.findViewById(R.id.pizzaName)
        val price : TextView = v.findViewById(R.id.pizzaPrice)
        val img: ImageView = v.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyItemView {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.pizza_item,parent,false)
        return MyItemView(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(item: MyItemView, position: Int) {
        item.name.text = list.get(position).name
        item.price.text = "${list.get(position).price} RUB"
        Picasso.get().load(list.get(position).image).into(item.img)
        item.itemView.setOnClickListener {
            Snackbar.make(item.itemView,"N $position",Snackbar.LENGTH_LONG).show()
        }
    }
}