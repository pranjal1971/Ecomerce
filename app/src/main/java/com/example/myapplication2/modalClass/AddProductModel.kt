package com.example.myapplication2.modalClass

data class AddProductModel(
    val product_name: String? = " ",
    val product_discription: String? = " ",
    val product_mrp: String? = " ",
    val product_sp: String? = " ",
    val productId: String? = " ",
    val productCategory: String? = " ",
    val productCoverimg: String? = " ",
    val listImage: ArrayList<String> = ArrayList()
)
