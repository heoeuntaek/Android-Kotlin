package com.example.ch10

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

private const val TAG = "Orientation"

class ViewModel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)




        val dataViewModel =
            ViewModelProvider(this)[CommonDataViewModel::class.java]
//            ViewModelProvider(this).get(CommonDataViewModel::class.java)
        var nameEditText: EditText = findViewById(R.id.nameEditText)
        var confirmButton: Button = findViewById(R.id.confirmButton)
        Log.d(TAG, "onCreate() 호출")

        nameEditText.setText(dataViewModel.inputString)
        confirmButton.setOnClickListener {
            dataViewModel.saveString(nameEditText.text.toString())
            nameEditText.setText(dataViewModel.inputString)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() 호출")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart() 호출")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() 호출")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() 호출")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() 호출")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() 호출")
    }
}