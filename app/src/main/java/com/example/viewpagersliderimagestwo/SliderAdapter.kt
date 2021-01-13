package com.example.viewpagersliderimagestwo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class SliderAdapter(
    list: ArrayList<Fragment>,
    fm: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fm, lifecycle) {

    private var fragmentItems: List<Fragment> = list

    override fun getItemCount() = fragmentItems.size
    override fun createFragment(position: Int) = fragmentItems[position]
}