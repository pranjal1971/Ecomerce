package com.example.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.NavController.OnDestinationChangedListener
import androidx.navigation.NavDestination
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.myapplication2.databinding.ActivityMainBinding
import com.google.android.play.integrity.internal.i


class MainActivity : AppCompatActivity() {
    private  lateinit var  binding:ActivityMainBinding
            private var i=0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //calling inflate function of ActivityMainBuilding class and passing layoutInflater as parameter
        binding=ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        val navHostFragment=supportFragmentManager.findFragmentById(R.id.frameLayout)
        val navController=navHostFragment!!.findNavController()



        val popupMenu=PopupMenu(this,null)
        popupMenu.inflate(R.menu.bottom_menu)
        binding.bottomNavigationView.setupWithNavController(popupMenu.menu,navController)

        binding.bottomNavigationView.onItemSelected={
            when(it){
                0->{
                   i =0;
                   navController.navigate(R.id.home_Fragment)
                }
                1-> i=1
                2-> i=2
            }
        }

    }


    override fun onBackPressed() {
        super.onBackPressed()
        if(i==0){
            finish()
        }

    }






}