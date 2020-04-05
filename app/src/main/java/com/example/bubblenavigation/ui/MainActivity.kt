package com.example.bubblenavigation.ui

import android.graphics.Typeface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.bubblenavigation.R
import com.example.bubblenavigation.ui.fragment.*
import com.example.bubblenavigation.utils.ScreenSlidePagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private val fragList = ArrayList<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openFragment()
        setTypeface()
        setBadgeValue()
        setPagerAdapter()
        addPageChangeListener()
        setNavigationChangeListener()

    }

    private fun setTypeface() {
        bottom_navigation_view_linear.setTypeface(Typeface.createFromAsset(assets, "rubik.ttf"))
    }

    private fun setNavigationChangeListener() {
        bottom_navigation_view_linear.setNavigationChangeListener { _, position ->
            view_pager.setCurrentItem(
                position,
                true
            )
        }
    }

    private fun addPageChangeListener() {
        view_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(i: Int, v: Float, i1: Int) {}

            override fun onPageSelected(i: Int) {
                bottom_navigation_view_linear.setCurrentActiveItem(i)
            }

            override fun onPageScrollStateChanged(i: Int) {}
        })
    }

    private fun setPagerAdapter() {
        val pagerAdapter =
            ScreenSlidePagerAdapter(
                fragList,
                supportFragmentManager
            )
        view_pager.adapter = pagerAdapter
    }

    private fun setBadgeValue() {
        bottom_navigation_view_linear.setBadgeValue(0, null)
        bottom_navigation_view_linear.setBadgeValue(1, null) //invisible badge

        bottom_navigation_view_linear.setBadgeValue(2, "7")
        bottom_navigation_view_linear.setBadgeValue(3, null)
        bottom_navigation_view_linear.setBadgeValue(4, null) //empty badge
    }

    private fun openFragment() {
        fragList.add(
            HomeFragment()
        )
        fragList.add(
            SearchFragment()
        )
        fragList.add(
            FavsFragment()
        )
        fragList.add(
            NotifyFragment()
        )
        fragList.add(
            ProfileFragment()
        )
    }
}
