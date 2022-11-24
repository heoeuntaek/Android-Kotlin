package com.example.ads

import android.graphics.Color
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_radiobutton.*


class RadioButton : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radiobutton)

        val root = findViewById<ConstraintLayout>(R.id.root)

//        root.setBackgroundColor(Color.parseColor("#ff0000"))

        val radioRed: RadioButton = findViewById(R.id.radioRed)
        val radioBlue: RadioButton = findViewById(R.id.radioBlue)
        val radioGreen: RadioButton = findViewById(R.id.radioGreen)

        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            var sb = StringBuilder()
            var rdButton: RadioButton = findViewById(checkedId)
            when (checkedId) {
                R.id.radioRed -> {
                    showToast(radioRed.text.toString())
                    root.setBackgroundColor(Color.parseColor("#ff0000"))
                }


                R.id.radioBlue -> {
                    showToast(radioBlue.text.toString())
                    root.setBackgroundColor(Color.parseColor("#0000ff"))

                }
                R.id.radioGreen -> {
                    showToast(radioGreen.text.toString())
                    root.setBackgroundColor(Color.parseColor("#008000"))

                }
                else -> showToast("")
            }
            sb.append(rdButton.text)
            sb.append(" 을(를) 선택했군요")
            showToast(sb.toString())
//            Toast.makeText(
//                applicationContext, sb.toString(),
//                Toast.LENGTH_SHORT
//            ).show()
        }
        buttonSelect.setOnClickListener {
            println("버튼 클릭")
            when(radioGroup.checkedRadioButtonId){
                R.id.radioRed -> {
                    showToast(radioRed.text.toString())
                    root.setBackgroundColor(Color.parseColor("#ff0000"))
                    println("빨갱이")
                }


                R.id.radioBlue -> {
                    showToast(radioBlue.text.toString())
                    root.setBackgroundColor(Color.parseColor("#0000ff"))

                }
                R.id.radioGreen -> {
                    showToast(radioGreen.text.toString())
                    root.setBackgroundColor(Color.parseColor("#008000"))

                }
                else -> showToast("")
            }

        }
    }

    private fun showToast(str: String) {
        var msg = if (str.isNotEmpty()) {
            "$str 이 기본 선택되어 있습니다."
        } else {
            "아무것도 선택되어 있지 않습니다."
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}