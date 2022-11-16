package com.example.main2

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.math.RoundingMode
import java.text.DecimalFormat

class setOnTouchListener : AppCompatActivity() {
    var sb= StringBuilder()
    //여러가지 출력결과를 합쳐(연결시켜) 출력
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_on_touch_listener)


        var myView = findViewById<View>(R.id.myView)
//        myView.setOnTouchListener(object : View.OnTouchListener {
//            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
//                handleTouch(event)
//                return true
//            }
//        })
//아래처럼 변경
        myView.setOnTouchListener { v, event ->
            handleTouch(event)
            true
        }



    }

    fun handleTouch(m: MotionEvent?) {
        if (m ==null) return
        var mx:Float = m.x
        var my:Float = m.y
        var textView = findViewById<TextView>(R.id.textView10)
        when (m.action){
            MotionEvent.ACTION_DOWN ->printFormatted("손을 누름", mx, my)
            MotionEvent.ACTION_UP ->printFormatted("손을 뗐습니다.", mx, my)
            MotionEvent.ACTION_MOVE ->printFormatted("손을 움직임", mx, my)
            else ->printFormatted("정의하지 않은 액션", mx, my )

//            MotionEvent.ACTION_DOWN ->sb.append("손을 터치. $mx, $my \n")
//            MotionEvent.ACTION_UP ->sb.append("손을 뗐습니다. $mx, $my \n")
//            MotionEvent.ACTION_MOVE ->sb.append("손을 움직임 $mx, $my \n")
//            else ->sb.append("정의하지 않은 액션 $mx, $my \n")
        }

//        textView.text = sb.toString()

    }
    fun printFormatted(msg:String, x:Float, y:Float) {
        var textView = findViewById<TextView>(R.id.textView10)
        var df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.CEILING

//        sb.append("%10s %.2f %.2f \n".format(msg, x, y))
        sb.append("$msg : ${df.format(x)}, ${df.format(y)}  \n")
        textView.text = sb.toString()
    }
}