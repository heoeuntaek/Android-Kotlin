package com.example.main2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class Implemented_in_code : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implemented_in_code)

        val linearLayout = LinearLayout(this)
        linearLayout.orientation = LinearLayout.VERTICAL

        val param =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
        linearLayout.layoutParams=param

        val a: Button



//
//        val linearLayout = LinearLayout(this)
//        linearLayout.orientation = LinearLayout.VERTICAL
//
//        val param =
//            LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.MATCH_PARENT
//            )
//        linearLayout.layoutParams = param
//
//        val btn = Button(this)
//
//        btn.text = "아녕"
//        btn.layoutParams = param
//
//        linearLayout.addView(btn)
//

        var myButton = findViewById<Button>(R.id.myButton)

        //첫번째방법
        myButton.setOnClickListener(MyListener())

        //두번째방법
        myButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val s: String = "안녕 안드로이드"
                var textView = findViewById<TextView>(R.id.textView)
                textView.text ="1"
            }
        })

        //세번째
        myButton.setOnClickListener {
            val s: String = resources.getString(R.string.text_message)
            var textView = findViewById<TextView>(R.id.textView)
            textView.text =s
        }

    }

    inner class MyListener : View.OnClickListener {
        override fun onClick(v: View?) {
            val s: String = "안녕 안드로이드"
            var textView = findViewById<TextView>(R.id.textView)

            textView.text = "sdf"

        }
    }
}