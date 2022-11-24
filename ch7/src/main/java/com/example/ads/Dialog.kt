package com.example.ads

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

        val items: Array<String> = resources.getStringArray(R.array.colors)
        var mSelect = 0
        var checked: Array<Boolean> = Array(3) { false }

//        items.forEach { i -> println("haha"+i)}


        button2.setOnClickListener {

            AlertDialog.Builder(this@Dialog)
                .setTitle("색상 선택")
//                .setMessage("색을 선택하시오")
                .setIcon(R.drawable.ic_launcher)
//                .setItems(items, object: DialogInterface.OnClickListener {
//                    override fun onClick(dialog: DialogInterface?, which: Int) {
//                        Toast.makeText(applicationContext,
//                            "${items[which]} is selected",
//                            Toast.LENGTH_SHORT).show()
//                    }
//                })


//                .setSingleChoiceItems(items, mSelect, object:DialogInterface.OnClickListener{
//                    override fun onClick(dialog: DialogInterface?, which: Int) {
//                        mSelect = which
//                    }
//                })

//                .setSingleChoiceItems(items, mSelect) { _, which ->
//                    mSelect = which
//                }

                .setMultiChoiceItems(
                    items,
                    null,
                    object : DialogInterface.OnMultiChoiceClickListener {
                        override fun onClick(
                            dialog: DialogInterface?,
                            which: Int,
                            isChecked: Boolean
                        ) {
                            checked[which] = isChecked
                        }
                    })

                .setMultiChoiceItems(
                    items,
                    null
                ) { _, which, isChecked ->
                    checked[which] = isChecked
                }


//                .setPositiveButton("Select", object : DialogInterface.OnClickListener {
//                    override fun onClick(dialog: DialogInterface?, which: Int) {
//                        finish()
//                    }
//                })

                .setPositiveButton("Select") { _, _ ->
                    Toast.makeText(
                        applicationContext,
                        "${items[mSelect]} is selected",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                .setPositiveButton("Select") { _, _ ->
                    var sb = StringBuffer()
                    for (i in checked.indices) {
                        if (checked[i]) {
                            sb.append("${items[i]}, ")
                        }
                    }

                    Toast.makeText(
                        applicationContext,
                        "$sb is selected",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                .setNegativeButton("Cancel", null)


                .show()
        }
    }
}