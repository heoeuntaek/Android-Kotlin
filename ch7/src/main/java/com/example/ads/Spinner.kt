package com.example.ads

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Spinner : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)

        val planets = resources.getStringArray(R.array.planets_array)
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item, planets
        )
        val spinner: Spinner = findViewById(R.id.spinner)
        spinner.adapter = adapter

        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )

        spinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?, position: Int, id: Long
                ) {
                    var planet = parent?.getItemAtPosition(position).toString()

                    Toast.makeText(
                        parent?.context,
                        "선택된 행성은 $planet",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }
    }
}

