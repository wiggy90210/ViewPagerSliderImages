package com.example.viewpagersliderimagestwo

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class SliderAdapter(
        fragment: Fragment
) : FragmentStateAdapter(fragment) {

    private var fragmentItems: ArrayList<Fragment> = arrayListOf()

    override fun getItemCount() = fragmentItems.size
    override fun createFragment(position: Int): Fragment {
        return fragmentItems[position]
    }

    fun addFragment(fragment: Fragment) {
        fragmentItems.add(fragment)
        notifyDataSetChanged()
    }
}