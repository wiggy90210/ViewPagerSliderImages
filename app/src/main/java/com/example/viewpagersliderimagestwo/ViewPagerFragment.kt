package com.example.viewpagersliderimagestwo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import me.relex.circleindicator.CircleIndicator3


class ViewPagerFragment : Fragment() {

    lateinit var fragmentView: View
    lateinit var adapter: SliderAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentView =  inflater.inflate(R.layout.fragment_view_pager, container, false)
        val viewPager: ViewPager2 = fragmentView.findViewById(R.id.viewpager)
        val indicator3: CircleIndicator3 = fragmentView.findViewById(R.id.indicator)

        adapter = SliderAdapter(this)

        viewPager.adapter = adapter
        viewPager.offscreenPageLimit = 5
        viewPager.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        viewPager.setPageTransformer(CrossfadePageTransformer())
        indicator3.setViewPager(viewPager)
        adapter.registerAdapterDataObserver(indicator3.adapterDataObserver)
        indicator3.bringToFront()

        return fragmentView
    }

    class CrossfadePageTransformer() : ViewPager2.PageTransformer {

        override fun transformPage(view: View, position: Float) {
            val pageWidth = view.width
            val imageView: View = view.findViewById(R.id.image_view)
            val contentView: View = view.findViewById(R.id.fragment_text)

            when {
                position <= 0 -> {
                    view.translationX = pageWidth * -position
                    contentView?.let { contentView.translationX = pageWidth * position }
                    imageView?.let { imageView.alpha = 1 + position }
                }
                position <= 1 -> {
                    view.translationX = pageWidth * -position
                    contentView?.let { contentView.translationX = pageWidth * position }
                    imageView?.let { imageView.alpha = 1 - position }
                } else -> {}
            }
        }
    }
}




