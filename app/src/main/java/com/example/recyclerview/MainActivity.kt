package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private var recycler : RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val exampleList = generateDummyList(500)

        recycler = findViewById(R.id.rv_view)

        recycler!!.adapter  = ExampleAdapter(exampleList)
        recycler!!.layoutManager = LinearLayoutManager(this)
        recycler!!.setHasFixedSize(true)
    }



    private  fun generateDummyList(size:Int): List<ExampleItem>{
        val list = ArrayList<ExampleItem>()

        for (i in 0 until size){
            val drawable = when (i% 3){
                0-> R.drawable.ic_baseline_local_florist
                1-> R.drawable.ic_audio
                else -> R.drawable.ic_sun
            }

            val item = ExampleItem(drawable, "item $1", "Line 2")
            list += item
        }

        return list
    }
}