package com.example.ch10

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {
    lateinit var editText:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        findViewById<Button>(R.id.button).setOnClickListener {
            var subIntent = Intent(this, SubActivity::class.java)
            val str = editText.text.toString()
            subIntent.putExtra(EXTRA_MESSAGE, str)
            startForResult.launch(subIntent)
        }
    }

    private val startForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            if (result.data != null) {
                val extras:Bundle? = result.data?.extras
                val returnString = extras?.getString("return") ?: ""
                editText.setText(returnString)
            }
        }
    }
}





