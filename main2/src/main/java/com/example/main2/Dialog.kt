package com.example.main2

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_dialog.*

class Dialog : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        val colorArr: Array<String> = resources.getStringArray(R.array.colors)


        var checkedId = 0
        var checkedArr = booleanArrayOf(false, false, false)

        button.setOnClickListener {
            var builder = AlertDialog.Builder(this@Dialog)
                .setTitle("색상 선택")
//                .setSingleChoiceItems(colorArr, checkedId,
//                    object : OnClickListener {
//                        override fun onClick(d: DialogInterface?, which: Int) {
//                            checkedId = which
//
//                        }
//                    })
                //string builder 0- 출력 내용이 많을때 사용
                .setMultiChoiceItems(colorArr, checkedArr,
                    object : DialogInterface.OnMultiChoiceClickListener {
                        override fun onClick(
                            d: DialogInterface?,
                            which: Int,
                            b: Boolean
                        ) {  //boolean은 상태 정보
                            checkedArr[which] = b

                        }
                    })


                .setIcon(R.drawable.ic_launcher)
//                .setPositiveButton("Select", object : DialogInterface.OnClickListener {
//                    override fun onClick(dialog: DialogInterface?, which: Int) {
//                        finish()
//                    }
//                })
                .setPositiveButton("선택") { _, which ->
//                    showToast("which = $which")
//                    showToast("선택한 항목은 ${colorArr[checkedId]}")
                    var s: String = ""
                    checkedArr.forEachIndexed { index, b ->
                        if (b)
                            s += "colorArr[index]"
                        if (s.isNotEmpty()) {
                            showToast("선택항목은 $b")
                        } else
                            showToast("please select colors")

                    }
                }


                .setNegativeButton("Cancel", object : DialogInterface.OnClickListener {
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        Toast.makeText(
                            applicationContext, "명령 취소",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                })
                .show()
        }

    }

    private fun showToast(s: String) {
        Toast.makeText(applicationContext, s, Toast.LENGTH_SHORT).show()

    }

}



