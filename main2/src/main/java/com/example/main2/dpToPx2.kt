package com.example.main2



import android.annotation.SuppressLint
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.roundToInt


class dpToPx2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dp_to_px2)

        val density:Float = resources.displayMetrics.density
        val dp:Int = 10
        val scale:Float = resources.displayMetrics.density


        var textView = findViewById<TextView>(R.id.textView2)

        var button= findViewById<Button>(R.id.button)
        button.setOnClickListener{
            var px:Int = (dp*density+0.5).toInt()
            var msg  = " method1 1dp = $dp -> px = $px"
            textView.text = msg
        }

        var button3= findViewById<Button>(R.id.button3)
        button3.setOnClickListener{
            var px:Int = (scale*dp).roundToInt()
            var msg  = " method2 1dp = $dp -> px = $px"
            textView.text = msg
        }

        var button4= findViewById<Button>(R.id.button4)
        button4.setOnClickListener{
            var px:Int = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp.toFloat(), resources.displayMetrics).toInt()
            var msg  = " method3 1dp = $dp -> px = $px"
            textView.text = msg
        }






//        Log.i("dimension", "density= $density")
//        Log.i("dimension", "densityDpi= $densityDpi")
//
//        val dp = 10
//        Log.i
    }
}