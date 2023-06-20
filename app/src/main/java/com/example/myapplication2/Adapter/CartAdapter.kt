package com.example.myapplication2.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication2.Room.ProductModel
import com.example.myapplication2.databinding.CartItemBinding



class CartAdapter(val context: Context, val list: ArrayList<ProductModel>):
    RecyclerView.Adapter<CartAdapter.CartViewHolder>(){

        inner class CartViewHolder(binding:CartItemBinding):
            RecyclerView.ViewHolder(binding.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartAdapter.CartViewHolder {
        val binding=CartItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartAdapter.CartViewHolder, position: Int) {
        Glide.with(context).load(list[position].productCoverimg).
    }

    override fun getItemCount(): Int {
        return list.size
    }

}

