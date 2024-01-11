package com.example.navigationdrawerwithsharedpreferences

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.navigationdrawerwithsharedpreferences.databinding.ActivityMainBinding
import com.example.navigationdrawerwithsharedpreferences.ui.gallery.GalleryFragment
import com.example.navigationdrawerwithsharedpreferences.ui.home.HomeFragment
import com.example.navigationdrawerwithsharedpreferences.ui.profile.ProfileFragment
import com.example.navigationdrawerwithsharedpreferences.ui.slideshow.SlideshowFragment
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

//        binding.appBarMain.fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_INDEFINITE).apply {
//                animationMode = BaseTransientBottomBar.ANIMATION_MODE_SLIDE
//                setAction("Action") {
//                    binding.drawerLayout.openDrawer(GravityCompat.START)
//                }
//                show()
//            }
//        }
        val toggle = ActionBarDrawerToggle(this, binding.drawerLayout, binding.appBarMain.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)

        // Set the toggle button to open and close the Navigation Drawer
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> replaceFragment(HomeFragment())
                R.id.nav_slideshow -> replaceFragment(SlideshowFragment())
                R.id.nav_gallery -> replaceFragment(GalleryFragment())
                R.id.nav_profile -> replaceFragment(ProfileFragment())
            }
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
}