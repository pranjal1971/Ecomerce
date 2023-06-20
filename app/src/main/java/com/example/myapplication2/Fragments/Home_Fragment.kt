package com.example.myapplication2.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.myapplication2.Adapter.CateogryAdapter
import com.example.myapplication2.Adapter.ProductAdapter
import com.example.myapplication2.R
import com.example.myapplication2.databinding.FragmentHomeBinding
import com.example.myapplication2.modalClass.AddProductModel
import com.example.myapplication2.modalClass.CateogryModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Home_Fragment : Fragment() {

  private lateinit var binding: FragmentHomeBinding


    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentHomeBinding.inflate(layoutInflater)



        val preference=requireContext().getSharedPreferences("info", AppCompatActivity.MODE_PRIVATE)

        if(preference.getBoolean("isCart",false))
            findNavController().navigate(R.id.action_home_Fragment_to_cart_Fragment)



        getCategories()
        getProducts()
        return binding.root
    }

    private fun getProducts() {
        var list=ArrayList<AddProductModel>()
        Firebase.firestore.collection("products")
            .get().addOnSuccessListener {
                list.clear()
                for(doc in it.documents){
                    val data=doc.toObject(AddProductModel::class.java)
                    list.add(data!!)
                }
                binding.productrecycler.adapter= ProductAdapter(requireContext(),list)
            }
    }

    private fun getCategories() {
        var list=ArrayList<CateogryModel>()
        Firebase.firestore.collection("Cateogry")
            .get().addOnSuccessListener {
                list.clear()
                for(doc in it.documents){
                    val data=doc.toObject(CateogryModel::class.java)
                    list.add(data!!)
                }
                binding.categoryrecycler.adapter= CateogryAdapter(requireContext(), list)
            }
    }


}