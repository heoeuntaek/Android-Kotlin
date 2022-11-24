package com.example.ch10

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        var editText:EditText = findViewById(R.id.editText)
        val extras = intent.extras ?: null
        if (intent.hasExtra(EXTRA_MESSAGE)) {
            val message = extras?.getString(EXTRA_MESSAGE)
            editText.setText(message)
        }

        findViewById<Button>(R.id.button).setOnClickListener{
            val str = editText.text.toString( )
            val data = Intent( )
            data.putExtra("return", str)
            setResult(Activity.RESULT_OK, data)
            finish( )
        }
    }
}
