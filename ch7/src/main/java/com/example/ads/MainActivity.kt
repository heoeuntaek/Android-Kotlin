package com.example.ads

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        var btn = findViewById<Button>(R.id.btn1)
        var tv = findViewById<TextView>(R.id.txt1)
        btn.setOnClickListener {
            var strArr: Array<String> =resources.getStringArray(R.array.colors)
            var strArr2: Array<String> = Array(strArr.size){i->strArr[i]}

            val chArr:Array<Char> = Array(strArr2.size){ i -> (strArr2[i])[0]}
//            for (ch in chArr) {
//                sb.append("$ch=${ch.code}")
//            }

            //1번쨰
//            val s :String  ="원소개수 = ${strArr.size}, ${strArr[0]}, ${strArr[1]}, ${strArr[2]}"
            //2번쨰
            val sb = StringBuilder()
//            for (element in strArr){
//                sb.append(" $element")
//            }
            //4번쨰
//            strArr.forEach {
//                element ->sb.append("$element ")
//            }

            //5번쨰
//            strArr.forEachIndexed {
//               i, element-> sb.append("($i, $element)")
//            }

            //6번째
            val iterator:Iterator<String> =strArr.iterator()
            while (iterator.hasNext()) {
                var element = iterator.next()
                sb.append("$element, ")

            }

            //strArr2
            strArr2.sort()
            sb.append(strArr2.contentToString())

//            tv.text = sb.toString()
            //3번째
//            tv.text = strArr.contentToString()

            //문자열 배열 -> 실수 배열
            val strArr3:Array<String> = resources.getStringArray(R.array.numericalValue)
            val floatArr:Array<Float> = Array(strArr.size){ i -> strArr3[i].toFloat()}
            val sb2 = StringBuilder()

            floatArr.forEach {  element -> sb2.append("$element, ") }
            tv.text = sb2.toString()




        }


    }
}