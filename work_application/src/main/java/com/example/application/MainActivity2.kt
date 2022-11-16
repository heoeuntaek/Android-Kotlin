package com.example.work_application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.RadioGroup.OnCheckedChangeListener
import android.widget.Toast

var ifNull = true

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        val checkAmericano: CheckBox = findViewById(R.id.americanoCheckBox)
        val checkLatte: CheckBox = findViewById(R.id.latteCheckBox)
        val checkDecaf: CheckBox = findViewById(R.id.decafCheckBox)

        val coffeeArr: Array<String> = resources.getStringArray(R.array.coffee_menus)
        checkAmericano.text = coffeeArr[0]
        checkLatte.text = coffeeArr[1]
        checkDecaf.text = coffeeArr[2]

        checkAmericano.setOnCheckedChangeListener(
            object : CompoundButton.OnCheckedChangeListener {
                override fun onCheckedChanged(
                    view: CompoundButton?,
                    checked: Boolean
                ) {
                    showToast(checked, " ${checkAmericano.text} ")

                }
            })


        val selectButton = findViewById<Button>(R.id.selectButton)


        selectButton.setOnClickListener {

        }
    }


    private fun showToast(b: Boolean, str: String) {
        var msg = if (b) {
            "$str 을 선택하였습니다."
        } else {
            "$str 을 선택하지 않았습니다."
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }


}
