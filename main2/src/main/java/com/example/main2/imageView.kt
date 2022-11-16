package com.example.main2

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class imageView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_view)
    }
    var count :Int=0
    fun onButtonClicked(v: View) {
        count+=1
        var imageView = findViewById<ImageView>(R.id.imageView)
        var imageView2 = findViewById<ImageView>(R.id.imageView2)
        var imageView3= findViewById<ImageView>(R.id.imageView3)

        imageView.visibility = View.INVISIBLE;
        imageView2.visibility = View.INVISIBLE;
        imageView3.visibility = View.INVISIBLE;

        when(count %3){
            0 -> imageView.visibility = View.VISIBLE;
            1 -> imageView.visibility = View.VISIBLE;
            2 -> imageView.visibility = View.VISIBLE;
        }
}}