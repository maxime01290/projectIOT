package com.example.projectiot.View

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.projectiot.Adapter.AdapterBulb
import com.example.projectiot.Model.Bulb
import com.example.projectiot.Model.FirebaseSingleton
import com.example.projectiot.R


class FragmentBulb : Fragment(), AdapterBulb.onItemClickListenerCustom {

    lateinit var adapter:AdapterBulb
    val red = ArrayList<Int>()
    val purple = ArrayList<Int>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bulb, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initColor()
        val bulbList: ArrayList<Bulb> = ArrayList()

        val netflix = Bulb("netflix",true,R.drawable.netflix, red)
        val twitch = Bulb("twitch",false,R.drawable.twitch, purple)

        bulbList.add(netflix)
        bulbList.add(twitch)

        val recyclerView: RecyclerView? = activity?.findViewById(R.id.recyclerview_bulb)
        adapter = AdapterBulb(this.requireContext(),bulbList,this)
        recyclerView?.adapter = adapter
    }

    override fun onItemClick(position: Int) {
        for( i in 0..adapter.itemCount-1){
            if(i == position){
                adapter.list[i].isSelected = true
                FirebaseSingleton.r.setValue(adapter.list[i].RGB[0])
                FirebaseSingleton.g.setValue(adapter.list[i].RGB[1])
                FirebaseSingleton.b.setValue(adapter.list[i].RGB[2])
                FirebaseSingleton.mode.setValue(1)
            }else{
                adapter.list[i].isSelected = false
            }
        }
        adapter.notifyDataSetChanged()
    }

    fun initColor(){
        red.add(255)
        red.add(0)
        red.add(0)
        purple.add(255)
        purple.add(0)
        purple.add(255)
    }
}