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


        var sb = StringBuilder()
        if (americanoCheckBox.isChecked) sb.append(" ${americanoCheckBox.text} ")
        if (latteCheckBox.isChecked) sb.append(" ${latteCheckBox.text} ")
        if (decafCheckBox.isChecked) sb.append(" ${decafCheckBox.text} ")
        sb.append(" are ordered. Thanks!")

        Toast.makeText(
            applicationContext,
            sb.toString(), Toast.LENGTH_LONG
        ).show()


        selectButton.setOnClickListener {
            var sb = StringBuilder()

            if (americanoCheckBox.isChecked) {
                sb.append(americanoCheckBox.text)
                sb.append(" ${editAme.text.toString()} 잔 주문 \n")

            }

            if (latteCheckBox.isChecked) {
                sb.append(latteCheckBox.text)
                sb.append(" ${editLat.text.toString()} 잔 주문 \n")
            }
            if (decafCheckBox.isChecked) {
                sb.append(decafCheckBox.text)
                sb.append(" ${editDec.text.toString()} 잔 주문 \n")
            }

            Toast.makeText(applicationContext, sb.toString(), Toast.LENGTH_SHORT).show()


        }


    }


}



