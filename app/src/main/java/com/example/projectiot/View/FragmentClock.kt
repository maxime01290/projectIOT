package com.example.projectiot.View

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.projectiot.R
import java.util.*
import kotlin.time.ExperimentalTime
import kotlin.time.hours

class FragmentClock : Fragment() {
    var isSelected:Boolean = false
    var valueRGB:Int =0
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_clock, container, false)
    }

    @ExperimentalTime
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cardViewSettingClock:CardView = view.findViewById(R.id.cardView_setting_clock)
        val imageViewSettingClock:ImageView = view.findViewById(R.id.imageView_setting_clock)
        if(isSelected){
            imageViewSettingClock.setImageResource(android.R.drawable.btn_star_big_on)
        }else{
            imageViewSettingClock.setImageResource(android.R.drawable.btn_star_big_off)
        }
        getColorWithHours()
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

    @ExperimentalTime
    fun getColorWithHours() {
        val calendar = Calendar.getInstance()
        if(calendar.get(Calendar.HOUR)<12 && calendar.get(Calendar.HOUR)>6){
            valueRGB = Color.rgb(0,255,0)
        }else if(calendar.get(Calendar.HOUR)>21 && calendar.get(Calendar.HOUR)<6){
            valueRGB = Color.rgb(255,0,0)
        }else{
            valueRGB = Color.rgb(0,0,255)
        }
    }
}