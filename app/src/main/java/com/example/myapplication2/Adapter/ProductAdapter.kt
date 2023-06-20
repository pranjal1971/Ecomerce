package com.example.myapplication2.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication2.Activity.ProductDetailesActivity
import com.example.myapplication2.databinding.ProductItemBinding
import com.example.myapplication2.modalClass.AddProductModel

class ProductAdapter (val context: Context, val list :ArrayList<AddProductModel>)
    :RecyclerView.Adapter<ProductAdapter.ProductViewHolder>()
{
    inner class ProductViewHolder(val binding:ProductItemBinding)
        :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
                val binding=ProductItemBinding.inflate(LayoutInflater.from(context),parent,false)
                return ProductViewHolder(binding)

    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val data=list[position]

        Glide.with(context).load(data.productCoverimg).into(holder.binding.imageView)
        holder.binding.textView3.text=data.product_name
        holder.binding.textView4.text=data.productCategory
        holder.binding.textView5.text=data.product_mrp

        holder.binding.button4.text=data.product_sp


        holder.itemView.setOnClickListener{
            val intent= Intent(context, ProductDetailesActivity::class.java)
            intent.putExtra("id",list[position].productId)
            context.startActivity(intent)

        }
    }
}