package com.example.tinkoffproject.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.tinkoffproject.R
import com.example.tinkoffproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var controller:NavController
    private var binding:ActivityMainBinding?=null

    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater).also{
            setContentView(it.root)
        }
        controller=(supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment).navController

        val appBarConfiguration = AppBarConfiguration(
            topLevelDestinationIds = setOf(R.id.mainFragment),
            fallbackOnNavigateUpListener = ::onSupportNavigateUp
        )
        findViewById<Toolbar>(androidx.appcompat.R.id.action_bar)
            .setupWithNavController(controller, appBarConfiguration)

        binding?.run {
            bnvMain.setupWithNavController(controller)
        }
    }
    override fun onBackPressed() {
        binding?.run {
            if(bnvMain.selectedItemId!=R.id.mainFragment) {
                bnvMain.selectedItemId=R.id.mainFragment
            } else{
                super.onBackPressed()
            }
        }
    }
}