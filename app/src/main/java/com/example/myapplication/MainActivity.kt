package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder

data class Pizza(val name: String, val price: Int, val image: String)

class MainActivity : AppCompatActivity() {

    private lateinit var list: List<Pizza>
    private lateinit var rv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val result = application.assets
            .open("pizzas.json")
            .bufferedReader()
            .use { it.readText() }
        val gson = GsonBuilder().create()
        list = gson.fromJson(result,Array<Pizza>::class.java).toList()
        Log.d("RRR",list.toString())

        rv = findViewById(R.id.recyclerView)
        rv.adapter = MyAdapter(list)
        rv.layoutManager = LinearLayoutManager(this)

    }
}