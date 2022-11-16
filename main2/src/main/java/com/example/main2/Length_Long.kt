package com.example.main2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Length_Long : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_length_long)

        val myButton = findViewById<Button>(R.id.btn_now)
        var textView = findViewById<TextView>(R.id.txt_now)
        myButton.setOnClickListener {

            val t = Toast.makeText(applicationContext, "버튼을 누름", Toast.LENGTH_SHORT).show()

            textView.text = "버튼을 누름"

        }


        myButton.setOnLongClickListener {
            textView.text = "버튼 길게 누름"
            val t = Toast.makeText(applicationContext,"버튼 길게 누름", Toast.LENGTH_LONG).show()
            true


        }
    }
}