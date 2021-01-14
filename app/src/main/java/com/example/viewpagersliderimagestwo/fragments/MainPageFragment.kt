package com.example.viewpagersliderimagestwo.fragments

import android.content.res.TypedArray
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.viewpagersliderimagestwo.R

class MainPageFragment : Fragment() {

    lateinit var pageTitles: Array<String>
    lateinit var drawableList: TypedArray



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        position = arguments?.getInt(POSITION)

        pageTitles = resources.getStringArray(R.array.fragmentTitles)
        drawableList = resources.obtainTypedArray(R.array.drawableList)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view =  inflater.inflate(R.layout.fragment_main_page, container, false)
        val tvTitle: TextView = view.findViewById(R.id.fragment_text)
        val ivBackground: ImageView = view.findViewById(R.id.image_view)

        position?.let {
            tvTitle.text = pageTitles[position!!]
            ivBackground.setImageDrawable(drawableList.getDrawable(position!!))
        }
        return view
    }


    companion object {
        const val POSITION = "position"
        var position: Int? = null

        fun newInstance(position: Int): MainPageFragment {
            val fragment = MainPageFragment()
            val b = Bundle()
            b.putInt(POSITION, position)
            fragment.arguments = b
            return fragment
        }
    }
}