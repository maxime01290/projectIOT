package com.example.projectiot.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red
import com.apandroid.colorwheel.ColorWheel
import com.example.projectiot.Model.FirebaseSingleton
import com.example.projectiot.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FullCustomFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FullCustomFragment : Fragment() {

    var valueRGB:ArrayList<Int> =ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_full_custom, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val colorWheel = view.findViewById<ColorWheel>(R.id.colorWheel)
        val button = view.findViewById<Button>(R.id.buttonSend)
        val flashTime = view.findViewById<EditText>(R.id.etFlashTime)
        val nbLeds = view.findViewById<EditText>(R.id.etNbLeds)

        button.setOnClickListener {
            val currentColor = colorWheel.rgb

            valueRGB.clear()

            valueRGB.add(currentColor.red)
            valueRGB.add(currentColor.green)
            valueRGB.add(currentColor.blue)

            FirebaseSingleton.r.setValue(valueRGB[0])
            FirebaseSingleton.g.setValue(valueRGB[1])
            FirebaseSingleton.b.setValue(valueRGB[2])
            FirebaseSingleton.mode.setValue(1)
            if (nbLeds.text.toString() != "" && nbLeds.text.toString().toInt() > 1){
                FirebaseSingleton.nbLed.setValue(nbLeds.text.toString().toInt())
            }else{
                FirebaseSingleton.nbLed.setValue(1)
            }
            if (flashTime.text.toString() != "" && flashTime.text.toString().toDouble() > 0){
                FirebaseSingleton.tmpClignotement.setValue(flashTime.text.toString().toDouble()*1000)
            }else{
                FirebaseSingleton.tmpClignotement.setValue(-1)
            }



        }

    }
}