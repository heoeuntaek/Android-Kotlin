package com.example.ch12

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


private val wordBank = listOf<Word>(
    Word("부주의한, 소홀한", "degenerate", "unity", "inadvertent", "array", 3),
    Word("쇠약하게 하다", "vanity", "underhand", "enslave", "debilitate", 4),
    Word("(위험·곤란)제거하다", "artisan", "sadistic", "glossy", "obviate", 4),
    Word("우아한", "prostrate", "delude", "urbane", "renowned", 3),
    Word("활기있게 하다", "bereave", "enliven", "occult", "besiege", 2)
)

class WordViewModel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word_view_model)



    }
}