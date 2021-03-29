package com.example.projectiot.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.projectiot.R

class FragmentMusic : Fragment() {
    var frequency:Int = -1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_music, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textViewUpdateFrequency: TextView = view.findViewById(R.id.textView_update_frequencies)
        val cardViewButton: CardView = view.findViewById(R.id.cardView_button_frequencies)
        frequency = 0
        cardViewButton.setOnClickListener {
            textViewUpdateFrequency.setText(frequency.toString())
        }
    }

}