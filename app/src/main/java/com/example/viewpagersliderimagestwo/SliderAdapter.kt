package com.example.viewpagersliderimagestwo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.viewpagersliderimagestwo.fragments.MainPageFragment

class SliderAdapter(
        list: ArrayList<Fragment>,
        fm: FragmentManager,
        lifecycle: Lifecycle
) : FragmentStateAdapter(fm, lifecycle) {

    private var fragmentItems: ArrayList<Fragment> = list

    override fun getItemCount() = fragmentItems.size
    override fun createFragment(position: Int) = fragmentItems[position]

}