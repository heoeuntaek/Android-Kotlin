package com.example.main2

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


var i: Int = 0
var gravity = arrayOf(Gravity.TOP, Gravity.END, Gravity.CENTER, Gravity.BOTTOM)

class Event : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)

        val textView = findViewById<TextView>(R.id.textView)
        val btn = findViewById<Button>(R.id.change_btn)


        // 1. 내부클래스
        var listener = MyListener()
        btn.setOnClickListener(listener)


        // 2. 무명클래스+람다식
        btn.setOnClickListener {

            if (i % 3 == 0) {
                i = 0
            }
            textView.gravity = gravity[i]
            i++
        }

        //3. 인터페이스 상속
        btn.setOnClickListener(this)


    }

    // 1. 내부클래스
    inner class MyListener : View.OnClickListener {
        override fun onClick(p0: View?) {
            if (i % 3 == 0) {
                i = 0
            }
            val textView = findViewById<TextView>(R.id.textView)
            textView.gravity = gravity[i]
            i++

        }
    }


    //3. 인터페이스 상속
    override fun onClick(p0: View?) {
        if (i % 3 == 0) {
            i = 0
        }
        val textView = findViewById<TextView>(R.id.textView)
        textView.gravity = gravity[i]
        i++
    }

    class Event : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_event)

        }
    }
}