package com.example.ads

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main6.*

class RecyclerView : AppCompatActivity() {


//    var DataList = arrayListOf(
//        Data(R.drawable.chuu, "0번"),
//        Data(R.drawable.chuu, "1번"),
//        Data(R.drawable.chuu, "2번"),
//        Data(R.drawable.chuu, "3번"),
//        Data(R.drawable.chuu, "3번"),
//        Data(R.drawable.chuu, "3번"),
//        Data(R.drawable.chuu, "3번"),
//        Data(R.drawable.chuu, "3번"),
//        Data(R.drawable.chuu, "3번"),
//        Data(R.drawable.chuu, "3번"),
//        Data(R.drawable.chuu, "3번"),
//
//    )


    var DataListRecycle = arrayListOf(
        DataRecycle(R.drawable.chuu, "0번"),
        DataRecycle(R.drawable.chuu, "1번"),
        DataRecycle(R.drawable.chuu, "2번"),
        DataRecycle(R.drawable.chuu, "3번"),
        DataRecycle(R.drawable.chuu, "4번"),
        DataRecycle(R.drawable.chuu, "5번"),
        DataRecycle(R.drawable.chuu, "6번"),
        DataRecycle(R.drawable.chuu, "7번"),
        DataRecycle(R.drawable.chuu, "8번"),

        )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)


//        var recyclerView=findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter  = CustomAdapterRecycle(DataListRecycle,this)






//        var listView = findViewById<ListView>(R.id.listView)
//        listView.adapter = CustomAdapter(this, DataList)
//
//        listView.onItemClickListener  = AdapterView.OnItemClickListener { parent, view, position, id ->
//            val selectItem = parent.getItemAtPosition(position) as Data
//            Toast.makeText(this, selectItem.name, Toast.LENGTH_SHORT).show()
//        }



    }
}