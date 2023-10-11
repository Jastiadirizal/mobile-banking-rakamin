package com.example.navbaryhui
import com.example.navbaryhui.ProfileFragment
import com.example.navbaryhui.HomeFragment
import com.example.navbaryhui.TransactionFragment

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.MenuItem
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity() : AppCompatActivity(), NavigationBarView.OnItemSelectedListener,
    Parcelable {

    private lateinit var bottomNavigationView: BottomNavigationView
    private val profileFragment: Fragment = ProfileFragment()
    private val homeFragment: Fragment = HomeFragment()
    private val transactionFragment: Fragment = TransactionFragment()


    constructor(parcel: Parcel) : this() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottomView)
        bottomNavigationView.setOnItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.profile -> supportFragmentManager.beginTransaction().replace(R.id.flFragment, profileFragment).commit()
            R.id.home -> supportFragmentManager.beginTransaction().replace(R.id.flFragment, homeFragment).commit()
            R.id.transaction -> supportFragmentManager.beginTransaction().replace(R.id.flFragment, transactionFragment).commit()
        }
        return false
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }
}
