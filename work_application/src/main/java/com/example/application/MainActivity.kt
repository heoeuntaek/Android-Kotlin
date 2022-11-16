package com.example.work_application

import android.graphics.Color
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val root = findViewById<ConstraintLayout>(R.id.root)

//        root.setBackgroundColor(Color.parseColor("#ff0000"))

        val radioRed: RadioButton = findViewById(R.id.radioRed)
        val radioBlue: RadioButton = findViewById(R.id.radioBlue)
        val radioGreen: RadioButton = findViewById(R.id.radioGreen)

        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        when (radioGroup.checkedRadioButtonId) {
            R.id.radioRed -> {
                showToast(radioRed.text.toString())
                root.setBackgroundColor(Color.parseColor("#ff0000"))
            }


            R.id.radioBlue -> {
                showToast(radioBlue.text.toString())
                root.setBackgroundColor(Color.parseColor("#ff0000"))

            }
            R.id.radioGreen -> {
                showToast(radioGreen.text.toString())
                root.setBackgroundColor(Color.parseColor("#008000"))

            }
            else -> showToast("")
        }

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
                    root.setBackgroundColor(Color.parseColor("#ff0000"))

                }
                R.id.radioGreen -> {
                    showToast(radioGreen.text.toString())
                    root.setBackgroundColor(Color.parseColor("#008000"))

                }
                else -> showToast("")
            }
            sb.append(rdButton.text)
            sb.append(" 을(를) 선택했군요")
            Toast.makeText(
                applicationContext, sb.toString(),
                Toast.LENGTH_SHORT
            ).show()
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