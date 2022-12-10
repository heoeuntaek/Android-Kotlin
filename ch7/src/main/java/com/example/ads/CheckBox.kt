package com.example.ads

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_check_box.*

class CheckBox : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_box)


        val coffeeArr: Array<String> = resources.getStringArray(R.array.coffee_menus)
        americanoCheckBox.text = coffeeArr[0]
        latteCheckBox.text = coffeeArr[1]
        decafCheckBox.text = coffeeArr[2]


        var rdArray: Array<android.widget.CheckBox> =
            arrayOf(americanoCheckBox, latteCheckBox, decafCheckBox)

        var nothingSelected = true
        var case: Boolean = false

        selectButton.setOnClickListener {
            var sb = StringBuilder()

            if (americanoCheckBox.isChecked) {
                sb.append(americanoCheckBox.text)
                sb.append(" ${editAme.text.toString()} 잔 주문 \n")
                nothingSelected = false
            }

            if (latteCheckBox.isChecked) {
                sb.append(latteCheckBox.text)
                sb.append(" ${editLat.text.toString()} 잔 주문 \n")
                nothingSelected = false
            }
            if (decafCheckBox.isChecked) {
                sb.append(decafCheckBox.text)
                sb.append(" ${editDec.text.toString()} 잔 주문 \n")
                nothingSelected = false
            }


            // 메뉴 선택안했는데 수량은 1보다 큰 경우



            if (!americanoCheckBox.isChecked && editAme != null) case = true
            if (!latteCheckBox.isChecked && editLat != null) case = true
            if (!decafCheckBox.isChecked && editDec != null) case = true


            if (nothingSelected) {
                Toast.makeText(applicationContext, "아무것도 선택x", Toast.LENGTH_SHORT).show()
            }

            if (case) {
                Toast.makeText(applicationContext, "메뉴를 선택 안했습니다", Toast.LENGTH_SHORT).show()
            }


            if (!nothingSelected && !case)
                Toast.makeText(applicationContext, sb.toString(), Toast.LENGTH_SHORT).show()


        }


    }


}



