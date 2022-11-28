package com.example.ch11

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CommonDataViewModel : ViewModel( ) {
    private val mutableText: MutableLiveData<CharSequence> = MutableLiveData( )
    private val mutableTextSize: MutableLiveData<Float> = MutableLiveData( )

    fun setData(str: CharSequence, size:Float) {
        mutableText.value = str
        mutableTextSize.value = size
    }
    fun getTextData() : MutableLiveData<CharSequence> = mutableText
    fun getTextSizeData() : MutableLiveData<Float> = mutableTextSize
}
