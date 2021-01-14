package com.example.viewpagersliderimagestwo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.viewpagersliderimagestwo.R

class MainPageFragment : Fragment() {

    var data: FragmentData? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        data = arguments?.getParcelable<FragmentData>(BUNDLE_DATA)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view =  inflater.inflate(R.layout.fragment_main_page, container, false)
        val tvTitle: TextView = view.findViewById(R.id.fragment_text)
        val ivBackground: ImageView = view.findViewById(R.id.image_view)

        data?.let {
            tvTitle.text = it.title
            ivBackground.setImageDrawable(ContextCompat.getDrawable(requireContext(), it.drawable))
        }
        return view
    }

    companion object {
        const val BUNDLE_DATA = "data"

        fun newInstance(data: FragmentData): MainPageFragment {
            val fragment = MainPageFragment()
            val b = Bundle()
            b.putParcelable(BUNDLE_DATA, data)
            fragment.arguments = b
            return fragment
        }
    }
}