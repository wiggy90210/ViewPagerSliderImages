package com.example.viewpagersliderimagestwo

import android.content.res.TypedArray
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.viewpagersliderimagestwo.fragments.FragmentData
import com.example.viewpagersliderimagestwo.fragments.MainPageFragment

class SliderAdapter(
        private val itemsCount: Int,
        fragment: Fragment
) : FragmentStateAdapter(fragment) {

    //private var fragmentItems: ArrayList<Fragment> = arrayListOf()
    val pageTitles = fragment.resources.getStringArray(R.array.fragmentTitles)
    val drawableList = getResourceIdArray(fragment.resources.obtainTypedArray(R.array.drawableList))

    override fun getItemCount() = itemsCount
    override fun createFragment(position: Int): Fragment {
        val data = FragmentData(pageTitles[position], drawableList[position])
        return MainPageFragment.newInstance(data)
    }

    /*fun addFragment(fragment: Fragment) {
        fragmentItems.add(fragment)
        notifyDataSetChanged()
    }*/

    fun getResourceIdArray(typedArray: TypedArray): Array<Int> {
        val arr: Array<Int> = Array(typedArray.length()) { -1 }
        for (i in 0 until typedArray.length()) {
            arr[i] = (typedArray.getResourceId(i, -1))
        }
        return arr
    }
}