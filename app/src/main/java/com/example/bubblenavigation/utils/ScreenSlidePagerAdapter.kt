package com.example.bubblenavigation.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.bubblenavigation.utils.ScreenSlidePageFragment


/**
 * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
 * sequence.
 */
@Suppress("DEPRECATION")
class ScreenSlidePagerAdapter(
    private val fragmentList: ArrayList<Fragment>,
    fm: FragmentManager
) : FragmentStatePagerAdapter(fm) {

    override fun getCount(): Int = fragmentList.size

    override fun getItem(position: Int): Fragment {
        if (position >= 0 && position < fragmentList.size)
            return fragmentList[position]
        return ScreenSlidePageFragment()
    }
}