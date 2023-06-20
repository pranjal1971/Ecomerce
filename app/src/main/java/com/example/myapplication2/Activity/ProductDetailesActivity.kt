package com.example.myapplication2.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.myapplication2.MainActivity
import com.example.myapplication2.R
import com.example.myapplication2.Room.AppDatabase
import com.example.myapplication2.Room.ProductDao
import com.example.myapplication2.Room.ProductModel
import com.example.myapplication2.databinding.ActivityProductDetailesBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductDetailesActivity : AppCompatActivity() {

    private lateinit var binding:ActivityProductDetailesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityProductDetailesBinding.inflate(layoutInflater)
        
        getProductDetails(intent.getStringExtra("id"))
        
        setContentView(binding.root)

    }

    private fun getProductDetails(proId: String?) {
         Firebase.firestore.collection("products")
             .document(proId!!).get().addOnSuccessListener {
               val list=it.get("productimages") as ArrayList<String>
                 val  pdName =it.getString("product_name")
                 val pdPrice =it.getString("product_sp")
                 val proDesc=it.getString("product_discription")


                 binding.pdName.text=pdName
                 binding.pdPrice.text=pdPrice
                 binding.proDesc.text=proDesc
                 val slideList=ArrayList<SlideModel>()
                 for(data in list){
                     slideList.add(SlideModel(data,ScaleTypes.CENTER_CROP))
                 }

                  cartAction(proId,pdName,pdPrice,it.getString("productCoverimg"))
                  binding.imageSlider.setImageList(slideList)
             }
             .addOnFailureListener {


             }
    }

    private fun cartAction(proId: String, pdName: String?, pdPrice: String?, coverImg: String?) {
        val productDao=AppDatabase.getInstance(this).productDao()

        if(productDao.isExist(proId)!=null){

          binding.addCart.text="Go to Cart"
        }
         else{
          binding.addCart.text="Add to Cart"
         }


        binding.addCart.setOnClickListener {

            if(productDao.isExist(proId)!=null){
                openCart()
            }
            else{
                addToCart(productDao,proId,pdName,pdPrice,coverImg)
            }
        }
    }

    private fun addToCart(
        productDao: ProductDao,
        proId: String,
        pdName: String?,
        pdPrice: String?,
        coverImg: String?
    ) {
           val data=ProductModel(proId,pdName,coverImg,pdPrice)
           lifecycleScope.launch(Dispatchers.IO){
               productDao.insertProduct(data)
               binding.addCart.text="Go to Cart"
           }

    }

    private fun openCart() {
       val preference=this.getSharedPreferences("info", MODE_PRIVATE)
        val editor=preference.edit()
        editor.putBoolean("isCart",true)
        editor.apply()

        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }

}