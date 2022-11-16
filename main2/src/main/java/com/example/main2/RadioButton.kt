package com.example.main2

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_radio_button.*

class RadioButton : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_button)


//        val radioRed: RadioButton = findViewById(R.id.radioRed)
//        val radioBlue: RadioButton = findViewById(R.id.radioBlue) as RadioButton
//        val radioGreen: RadioButton = findViewById(R.id.radioGreen) as RadioButton


        val lis = RadioListener();
        radioRed.setOnLongClickListener(lis)
        radioBlue.setOnLongClickListener(lis)
        radioGreen.setOnLongClickListener(lis)

//        LinearLayout 1page;


//        1page.setBackgroundColor(Color.parseColor("#000000"));


//        val colorArray: Array<String> =
//            resources.getStringArray(R.array.colors) radioRed.text = colorArray [0] radioBlue . text = colorArray [1] radioGreen . text = colorArray [2]
//        if (radioRed.isChecked) showToast(radioRed.text.toString()) else if (radioBlue.isChecked) showToast(
//            radioBlue.text.toString()
//        ) else if (radioGreen.isChecked) showToast(radioGreen.text.toString()) else showToast("")
//        val lis =
//            RadioListener() radioRed . setOnClickListener (lis) radioBlue . setOnClickListener (lis) radioGreen . setOnClickListener (lis)
//    }

    }


    inner class RadioListener : View.OnClickListener, View.OnLongClickListener {
        override fun onClick(v: View?) {
            if (v == null) return
            var sb = StringBuilder()
            when (v.id) {
                R.id.radioRed -> root.setBackgroundColor(Color.parseColor("#ff0000"))
                R.id.radioBlue -> root.setBackgroundColor(Color.parseColor("#0067a3"))
                R.id.radioGreen -> root.setBackgroundColor(Color.parseColor("#008000"))
                else -> 0

//            Toast.makeText(applicationContext, sb.toString(), Toast.LENGTH_SHORT).show()
            }
        }

        override fun onLongClick(p0: View?): Boolean {
            TODO("Not yet implemented")
        }


    }


}
