package com.example.ads

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val items:Array<String> = resources.getStringArray(R.array.colors)

        val callButton: Button = findViewById(R.id.callButton)
        callButton.setOnClickListener {
            AlertDialog.Builder(this@MainActivity)
                .setTitle("색을 선택하세요")
                .setIcon(R.drawable.ic_launcher)
                .setItems(items, object: DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        Toast.makeText(applicationContext,
                            "${items[which]} is selected",
                            Toast.LENGTH_SHORT).show()
                    }
                })
                .show()
        }
    }
}

