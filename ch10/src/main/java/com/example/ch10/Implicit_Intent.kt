package com.example.ch10

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Implicit_Intent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intent)

        findViewById<Button>(R.id.callButton).setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL,
                Uri.parse("tel:(+82)01012345678"))
            startActivity(intent)
        }
    }
}