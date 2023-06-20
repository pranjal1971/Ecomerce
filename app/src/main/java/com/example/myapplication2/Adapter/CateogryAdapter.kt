package com.example.myapplication2.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication2.Activity.CategoryActivity
import com.example.myapplication2.R
import com.example.myapplication2.databinding.CategoryItemBinding
import com.example.myapplication2.modalClass.CateogryModel

class CateogryAdapter(var context: Context, val list: ArrayList<CateogryModel>):RecyclerView.Adapter<CateogryAdapter.CateogryViewHolder>(){
    inner class CateogryViewHolder(view:View):RecyclerView.ViewHolder(view){
        var binding=CategoryItemBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CateogryViewHolder {
        return CateogryViewHolder(LayoutInflater.from(context).inflate(R.layout.category_item,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CateogryViewHolder, position: Int) {
        holder.binding.textView2.text=list[position].cat
        Glide.with(context).load(list[position].img).into(holder.binding.imageView3)

        holder.itemView.setOnClickListener{
            val intent=Intent(context,CategoryActivity::class.java)

            intent.putExtra("cat",list[position].cat)

            context.startActivity(intent)
        }
    }
}