package com.example.ch10

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
            var textView: TextView = view.findViewById(R.id.textView)
        }
    }
}