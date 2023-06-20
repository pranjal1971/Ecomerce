package com.example.myapplication2.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication2.Activity.ProductDetailesActivity
import com.example.myapplication2.R
import com.example.myapplication2.databinding.CategoryItemBinding
import com.example.myapplication2.databinding.ItemCategoryProductLayoutBinding
import com.example.myapplication2.databinding.ProductItemBinding
import com.example.myapplication2.modalClass.AddProductModel
import com.example.myapplication2.modalClass.CateogryModel

class ProductCategoryAdapter(var context: Context, val list: ArrayList<AddProductModel>)
    : RecyclerView.Adapter<ProductCategoryAdapter.ProductCategoryViewHolder>(){
    inner class ProductCategoryViewHolder(val binding: ItemCategoryProductLayoutBinding):
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductCategoryViewHolder {
        val binding= ItemCategoryProductLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return ProductCategoryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ProductCategoryViewHolder, position: Int) {
        Glide.with(context).load(list[position].productCoverimg).into(holder.binding.imageV)

        holder.binding.textV1.text=list[position].product_name
        holder.binding.textV2.text=list[position].product_sp

        holder.itemView.setOnClickListener{
            val intent= Intent(context,ProductDetailesActivity::class.java)
            intent.putExtra("id",list[position].productId)
            context.startActivity(intent)

        }
    }


}