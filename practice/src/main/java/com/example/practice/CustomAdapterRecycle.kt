package com.example.practice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.custom_list.view.*


class DataRecycle(val profile: Int, val name: String)

class CustomViewHolder(view:View):RecyclerView.ViewHolder(view){

    val profile = view.imageView
    val name = view.textView
}
//뷰홀더 - 한 화면에 나타나는 하나

class CustomAdapterRecycle(val DataList: ArrayList<DataRecycle>) : RecyclerView.Adapter<CustomViewHolder>() {

    //ViewHolder 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.custom_list, parent,false)
        return CustomViewHolder(view)
    }

    override fun getItemCount()=DataList.size  // 전체길이

    //viewholder 바인딩
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.profile.setImageResource(DataList[position].profile)
        holder.name.text = DataList[position].name

        holder.itemView.setOnClickListener{v->
            Toast.makeText(v.context, DataList[position].name, Toast.LENGTH_SHORT).show()

        }
    }



}