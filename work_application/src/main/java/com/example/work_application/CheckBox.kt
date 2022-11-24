package com.example.work_application

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CheckBox : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val checkAmericano = findViewById<CheckBox>(R.id.americanoCheckBox)
        val checkLatte = findViewById<CheckBox>(R.id.latteCheckBox)
        val checkDecaf = findViewById<CheckBox>(R.id.decafCheckBox)
        // 음료 배열: 원소 타입은 CheckBox
        var menuArray:Array<CheckBox> = arrayOf(checkAmericano, checkLatte, checkDecaf)

        val americanoQty: EditText = findViewById(R.id.americanoEditText)
        val latteQty:EditText = findViewById(R.id.latteEditText)
        val decafQty:EditText = findViewById(R.id.decafEditText)
        var editArray:Array<EditText> = arrayOf(americanoQty, latteQty, decafQty)

        val coffeeArr:Array<String> = resources.getStringArray(R.array.coffee_menus)

        // 음료 메뉴를 coffeeArr 원소(문자열)로 초기화
        menuArray.forEachIndexed { index, checkBox ->
            checkBox.text = coffeeArr[index]
        }

        val selectButton: Button = findViewById(R.id.selectButton)
        selectButton.setOnClickListener {
            var qtyArray:Array<Int> = Array(3){ 0 }
            editArray.forEachIndexed { i, editText ->
                if (editText.text.isNotEmpty())
                    qtyArray[i] = editText.text.toString().toInt()
            }

            var sb = StringBuilder()
            var errorType = 1

            menuArray.forEachIndexed { i, menu ->
                if (menu.isChecked) {
                    if (qtyArray[i] > 0) {
                        sb.append(" (${menu.text}=${qtyArray[i]}잔) ")
                    } else // 음료는 선택. 수량은 미지정
                        errorType = 2
                } else if (qtyArray[i] > 0) { // 음료는 미선택. 수량은 지정
                    errorType = 3
                }
            }

            if (sb.isNotEmpty()) {
                sb.append("are ordered. Thanks!")
                showToast(sb.toString())
            } else {
                when (errorType) {
                    1 -> showToast("Nothing selected. Please order again.")
                    // error=1: 아무 것도 선택하지 않음
                    2 -> showToast("Wrong choice. Enter quantity please.")
                    // error=2: 음료는 선택. 수량은 미지정
                    3 -> showToast("Wrong choice. Select your drink please.")
                    // error=3: 음료는 미선택. 수량은 지정
                }
            }
        }
    }

    private fun showToast(msg:String) {
        Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
    }
}