package com.example.ch10

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class Componion : AppCompatActivity() {
    companion object {
        const val TAG = "Orientation"
        const val KEY_NAME = "first_name"
    }
    private lateinit var nameEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_componion)

        nameEditText = findViewById(R.id.nameEditText)
        Log.d(TAG, "onCreate() 호출")

        if (savedInstanceState?.isEmpty == false) {
            var str:String? = savedInstanceState?.getString(KEY_NAME)
            nameEditText.setText(str)
        }
    }


}