package com.example.projectiot.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.projectiot.Model.FirebaseSingleton
import com.example.projectiot.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener


class FragmentMusic : Fragment() {
    var frequency:Int =-1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_music, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textViewUpdateFrequency: TextView = view.findViewById(R.id.textView_update_frequencies)
        val cardViewButton: CardView = view.findViewById(R.id.cardView_button_frequencies)
        cardViewButton.setOnClickListener {
            FirebaseSingleton.tmpClignotement.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    frequency = dataSnapshot.getValue(Int::class.java)!!
                    System.out.println(frequency)
                    textViewUpdateFrequency.setText(frequency.toString())

                }

                override fun onCancelled(error: DatabaseError) {
                    // Failed to read value
                }
            })
        }
    }

}

