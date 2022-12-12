package com.example.main2

import android.os.Bundle
import android.util.TypedValue
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_exchange.*

class exchange : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exchange)

        amountTextView
        wonEditText
        convertButton

        var bgId = findViewById<ConstraintLayout>(R.id.screen_background)
        val bgColor =ContextCompat.getColor(this,R.color.color_background)
        bgId.setBackgroundColor(bgColor)

        val rate = resources.getString(R.string.exchange_rate).toDouble()
//        convertButton.setOnClickListener {
//            var wonvalue = wonEditText.text.toString()
//            if (wonvalue.isNotEmpty()) {
//                var dollorValue: Double = wonvalue.toDouble() / rate
//            amountTextView.text=dollorValue.toString()
////                amountTextView.text = String.format("%.1f", wonvalue / rate)
//            } else {
//                Toast.makeText(applicationContext, "입력하시오", Toast.LENGTH_SHORT).show()
//            }
//        }

        val convertButton: Button = findViewById(R.id.convertButton)
        convertButton.setOnClickListener {
            exchangeCurrency(wonEditText.text.toString())
        }

//        wonEditText.setOnEditorActionListener(object :TextView.OnEditorActionListener{
//            override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
//                if (actionId == EditorInfo.IME_ACTION_DONE || actionId ==EditorInfo.IME_ACTION_SEND) {
//                    exchangeCurrency(v?.text.toString())
//                    Toast.makeText(applicationContext, wonEditText.text, Toast.LENGTH_LONG).show()
//                    return true
//                }
//                return false
//            }
//        })

        // 람다식 변환 아래로
        wonEditText.setOnEditorActionListener{textView, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE || actionId ==EditorInfo.IME_ACTION_SEND) {
                exchangeCurrency(textView?.text.toString())
                Toast.makeText(applicationContext, wonEditText.text, Toast.LENGTH_LONG).show()
                true

            }
            false
        }


    }

    private fun exchangeCurrency(value: String) {
        var s:String = value
        if (s.isNotEmpty()) {
            val bgId:ConstraintLayout = findViewById(R.id.screen_background)
            val bgColor = ContextCompat.getColor(this, R.color.color_background)
            bgId.setBackgroundColor(bgColor)

            val color = ContextCompat.getColor(this, R.color.color_textview)

            val textSizeDP = resources.getDimension(R.dimen.textview_size)
            var amountTextView: TextView = findViewById(R.id.amountTextView)
            amountTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, textSizeDP)
            amountTextView.setTextColor(color)

            if (s.contains(".")) {
                s = s.replace(".", "")
            }
            var wonValue:Double = s.toDouble()
            val rate: Double = getString(R.string.exchange_rate).toDouble()
            amountTextView.text = String.format("%.1f", wonValue / rate)
        } else {
            Toast.makeText(applicationContext, "금액을 입력하세요",
                Toast.LENGTH_LONG).show()
        }
    }


}
