package com.example.ch10

import androidx.lifecycle.ViewModel

class CommonDataViewModel : ViewModel() {
    var inputString = ""

    fun saveString(str:String) {
        inputString = str
    }
}