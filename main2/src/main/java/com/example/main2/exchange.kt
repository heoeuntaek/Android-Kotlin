package com.example.main2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_exchange.*
import kotlinx.android.synthetic.main.activity_main.*

class exchange : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exchange)

        amountTextView
        wonEditText
        convertButton


        val rate = resources.getString(R.string.exchange_rate).toDouble()
        convertButton.setOnClickListener {
            var wonvalue = wonEditText.text.toString()
            if (wonvalue.isNotEmpty()) {
                var dollorValue: Double = wonvalue.toDouble() / rate
//            amountTextView.text=dollorValue.toString()
//                amountTextView.text = String.format("%.1f", wonvalue / rate)
            } else {
                Toast.makeText(applicationContext,"입력하시오", Toast.LENGTH_SHORT).show()
            }
        }

//        wonEditText.setOnEditorActionListener()







    }
}