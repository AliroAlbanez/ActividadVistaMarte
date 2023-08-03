package com.example.actividad7m6.vistas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.actividad7m6.R
import com.example.actividad7m6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mBinding: ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(mBinding.navegadorView.id) as NavHostFragment
        navController = navHostFragment.navController

    }
}