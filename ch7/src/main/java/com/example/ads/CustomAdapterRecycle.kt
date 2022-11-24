package com.example.ads

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.custom_list.view.*


class DataRecycle(val profile: Int, val name: String)

class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val profile = view.imageView
    val name = view.textView
}
//뷰홀더 - 한 화면에 나타나는 하나

class CustomAdapterRecycle(val DataList: ArrayList<DataRecycle>, val context: Context) :
    RecyclerView.Adapter<CustomViewHolder>() {

    //View 생성해서 Viewholder에 넣어서 리턴
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.custom_list, parent, false)
        return CustomViewHolder(view)
    }

    override fun getItemCount() = DataList.size  // 전체길이

    //viewholder 바인딩
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {


//            holder.profile.setImageResource(DataList[position].profile)
//            holder.name.text = DataList[position].name
//
//            holder.itemView.setOnClickListener{v->
//                Toast.makeText(v.context, DataList[position].name, Toast.LENGTH_SHORT).show()

        val curData = DataList[position]
        holder.profile.setImageResource(curData.profile)
        holder.name.text = curData.name

//        holder.itemView.setOnClickListener { v ->
//            Toast.makeText(v.context, curData.name, Toast.LENGTH_SHORT).show()
//
//        }
        holder.itemView.setOnClickListener {
            Toast.makeText(context, curData.name, Toast.LENGTH_SHORT).show()

        }
    }


}