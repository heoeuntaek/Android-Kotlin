package com.example.ch11_recycler

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class FruitFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private val fruitViewModel: FruitViewModel by lazy {
        ViewModelProvider(this).get(FruitViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(
            R.layout.fragment_fruit,
            container, false)
        val recyclerView: RecyclerView
                = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val fruits = fruitViewModel.fruitList
        var adapter = MyAdapter(fruits)
        recyclerView.adapter = adapter
        return view
    }

    private inner class MyViewHolder(view: View):
        RecyclerView.ViewHolder(view), View.OnClickListener {
        private lateinit var fruit: Fruit
        private val itemTitle: TextView = view.findViewById(R.id.title)
        private val itemCalories: TextView = view.findViewById(R.id.calories)
        private val itemSciName: TextView = view.findViewById(R.id.scientificName)
        private val itemImage: ImageView = view.findViewById(R.id.image)
        init {
            itemView.setOnClickListener(this)
        }
        fun bind(fruit: Fruit) {
            this.fruit = fruit
            itemTitle.text = this.fruit.name
            itemCalories.text = this.fruit.calories
            itemSciName.text = this.fruit.sciName
            itemImage.setImageResource(this.fruit.resId)
        }
        override fun onClick(v: View?) {
            Toast.makeText(context, "${fruit.name} pressed",
                Toast.LENGTH_SHORT).show()
        }
    }

    private inner class MyAdapter(var list: List<Fruit>)
        :RecyclerView.Adapter<MyViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup,
                                        viewType: Int): MyViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val view = inflater.inflate(R.layout.item, parent,
                false)
            return MyViewHolder(view)
        }
        override fun onBindViewHolder(holder: MyViewHolder,
                                      position: Int) {
            val fruit = list[position]
            holder.bind(fruit)
        }
        override fun getItemCount() = list.size
    }
}
