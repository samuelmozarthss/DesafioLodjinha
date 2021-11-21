package com.example.aulalodjinha.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.aulalodjinha.R
import com.example.aulalodjinha.databinding.ActivityMainBinding

interface NavigationDelegate {
    fun setToolbarTitle(title: String)
}


class MainActivity : AppCompatActivity(), NavigationDelegate {

    private lateinit var binding: ActivityMainBinding

    private val navigator by lazy { findNavController(R.id.nav_host_fragment)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setupNavigationView()
        setupNavigation()
    }

    private fun setupNavigation() {
        navigator.addOnDestinationChangedListener { _, destination, _ ->

            binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)

            for (i in 0 until binding.topAppBar.childCount) {
                val view = binding.topAppBar.getChildAt(i)
                if (view is android.widget.TextView && view.text == destination.label) {
                    val typeface = androidx.core.content.res.ResourcesCompat.getFont(this, R.font.pacificoregular)
                    view.typeface = typeface
                    break
                }
            }


            when(destination.id) {
                R.id.mainFragment -> {
                    binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
                }
                R.id.aboutFragment -> {
                    binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_OPEN)
                }
                else -> {
                }
            }
        }
    }

    private fun setupNavigationView() {
        binding.topAppBar.setupWithNavController(navigator, binding.drawerLayout)
        binding.navigationView.setupWithNavController(navigator)
    }

    override fun setToolbarTitle(title: String) {
        binding.topAppBar.title = title
    }
}