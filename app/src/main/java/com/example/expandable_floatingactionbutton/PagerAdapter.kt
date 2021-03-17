package com.example.expandable_floatingactionbutton

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {

        return when (position){
            0 -> {
                MondayFragment()
            }
            1 -> {
                TuesdayFragment()
            }
            2 -> {
                WednesdayFragment()
            }
            3 -> {
                ThursdayFragment()
            }
            4 -> {
                FridayFragment()
            }

            else -> {
                MondayFragment()
            }
        }

    }

    override fun getCount(): Int {

        return 5

    }
}