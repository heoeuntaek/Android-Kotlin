package com.example.ch11

import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity(), FragmentA.ButtonListener  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fragment_container: FrameLayout =
            findViewById(R.id.fragment_container)
        if (fragment_container != null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, FragmentA())
                .addToBackStack(null)
                .commit()
        }

        findViewById<Button>(R.id.buttonA).setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, FragmentA())
                addToBackStack(null)
                commit()
            }
        }
        findViewById<Button>(R.id.buttonB).setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, FragmentB())
                addToBackStack(null)
                commit()
            }
        }
    }

    override fun onButtonClick() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, FragmentB())
            .addToBackStack(null)
            .commit()
    }
}


