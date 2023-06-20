package com.example.myapplication2.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication2.Adapter.CateogryAdapter
import com.example.myapplication2.Adapter.ProductCategoryAdapter
import com.example.myapplication2.R
import com.example.myapplication2.modalClass.AddProductModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class CategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        getProducts(intent.getStringExtra("cat"))
    }

    private fun getProducts(category: String?) {
        var list=ArrayList<AddProductModel>()
        Firebase.firestore.collection("products").whereEqualTo("productCategory",category)
            .get().addOnSuccessListener {
                list.clear()
                for(doc in it.documents){
                    val data=doc.toObject(AddProductModel::class.java)
                    list.add(data!!)
                }
                val recyclerView=findViewById<RecyclerView>(R.id.recyler_view)
                recyclerView.adapter= ProductCategoryAdapter(this,list)
            }
    }
}