package com.example.projectiot.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import com.example.projectiot.R

class FragmentClock : Fragment() {
    var isSelected:Boolean = false
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_clock, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cardViewSettingClock:CardView = view.findViewById(R.id.cardView_setting_clock)
        val imageViewSettingClock:ImageView = view.findViewById(R.id.imageView_setting_clock)
        if(isSelected){
            imageViewSettingClock.setImageResource(android.R.drawable.btn_star_big_on)
        }else{
            imageViewSettingClock.setImageResource(android.R.drawable.btn_star_big_off)
        }
        cardViewSettingClock.setOnClickListener {
            if(isSelected){
                isSelected = false
                imageViewSettingClock.setImageResource(android.R.drawable.btn_star_big_off)
            }else{
                isSelected = true
                imageViewSettingClock.setImageResource(android.R.drawable.btn_star_big_on)
            }

        }
    }
}