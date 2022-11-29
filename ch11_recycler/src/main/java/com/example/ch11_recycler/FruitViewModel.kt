package com.example.ch11_recycler

import androidx.lifecycle.ViewModel

class FruitViewModel: ViewModel() {
    var fruitList = listOf<Fruit>(
        Fruit("Apple", "학명: Malus domestica", "100g당 칼로리: 48kcal", R.drawable.apple),
        Fruit("Banana", "학명: Musa × paradisiaca",  "100g당 칼로리: 89kcal", R.drawable.banana),
        Fruit("Grape", "학명: Vitis vinifera",  "100g당 칼로리: 69kcal",R.drawable.grape),
        Fruit("Orange", "학명: Citrus × sinensis",  "100g당 칼로리: 47kcal",R.drawable.orange),
        Fruit("Papaya", "학명: Carica papaya",  "100g당 칼로리: 43kcal",R.drawable.papaya),
        Fruit("Pineapple", "학명: Ananas comosus",  "100g당 칼로리: 50kcal",R.drawable.pineapple),
        Fruit("Strawberry", "학명: Fragaria × ananassa",  "100g당 칼로리: 33kcal",R.drawable.strawberry),
        Fruit("Watermelon", "학명: Citrullus lanatus ",  "100g당 칼로리: 30kcal",R.drawable.watermelon))
}