package com.example.bubblenavigation

import android.graphics.Typeface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private val fragList = ArrayList<ScreenSlidePageFragment>()

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
            ScreenSlidePagerAdapter(fragList, supportFragmentManager)
        view_pager.adapter = pagerAdapter
    }

    private fun setBadgeValue() {
        bottom_navigation_view_linear.setBadgeValue(0, "40")
        bottom_navigation_view_linear.setBadgeValue(1, null) //invisible badge

        bottom_navigation_view_linear.setBadgeValue(2, "7")
        bottom_navigation_view_linear.setBadgeValue(3, "2")
        bottom_navigation_view_linear.setBadgeValue(4, "") //empty badge
    }

    private fun openFragment() {
        fragList.add(
            ScreenSlidePageFragment.newInstance(
                getString(R.string.home),
                R.color.red_inactive)
        )
        fragList.add(
            ScreenSlidePageFragment.newInstance(
                getString(R.string.search),
                R.color.blue_inactive
            )
        )
        fragList.add(
            ScreenSlidePageFragment.newInstance(
                getString(R.string.likes),
                R.color.blue_grey_inactive
            )
        )
        fragList.add(
            ScreenSlidePageFragment.newInstance(
                getString(R.string.notification),
                R.color.green_inactive
            )
        )
        fragList.add(
            ScreenSlidePageFragment.newInstance(
                getString(R.string.profile),
                R.color.purple_inactive
            )
        )
    }
}
