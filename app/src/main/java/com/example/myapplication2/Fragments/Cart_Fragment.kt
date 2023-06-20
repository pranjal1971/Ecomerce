package com.example.myapplication2.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication2.databinding.FragmentCartBinding


class Cart_Fragment : Fragment() {



    private lateinit var binding: FragmentCartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentCartBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment

        val preference=requireContext().getSharedPreferences("info", AppCompatActivity.MODE_PRIVATE)
        val editor = preference.edit()
        editor.putBoolean("isCart",false)
        editor.apply()
        return binding.root



    }


}