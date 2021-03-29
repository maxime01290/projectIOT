package com.example.projectiot.View

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.projectiot.Model.FirebaseSingleton
import com.example.projectiot.R
import java.util.*
import kotlin.collections.ArrayList
import kotlin.time.ExperimentalTime
import kotlin.time.hours

class FragmentClock : Fragment() {
    var isSelected:Boolean = false
    var valueRGB:ArrayList<Int> =ArrayList()
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
                getColorWithHours()
            }else{
                isSelected = true
                imageViewSettingClock.setImageResource(android.R.drawable.btn_star_big_on)
                getColorWithHours()
            }
        }
    }

    @ExperimentalTime
    fun getColorWithHours() {
        val calendar = Calendar.getInstance()
        valueRGB.clear()
        if(calendar.get(Calendar.HOUR)<12 && calendar.get(Calendar.HOUR)>6){
            valueRGB.add(0)
            valueRGB.add(255)
            valueRGB.add(0)
        }else if(calendar.get(Calendar.HOUR)>21 && calendar.get(Calendar.HOUR)<6){
            valueRGB.add(255)
            valueRGB.add(0)
            valueRGB.add(0)
        }else{
            valueRGB.add(0)
            valueRGB.add(0)
            valueRGB.add(255)
        }
        FirebaseSingleton.r.setValue(valueRGB[0])
        FirebaseSingleton.g.setValue(valueRGB[1])
        FirebaseSingleton.b.setValue(valueRGB[2])
    }
}