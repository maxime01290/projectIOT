package com.example.projectiot.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projectiot.Adapter.AdapterBulb
import com.example.projectiot.Model.Bulb
import com.example.projectiot.R


class FragmentBulb : Fragment(), AdapterBulb.onItemClickListenerCustom {

    lateinit var adapter:AdapterBulb

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bulb, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val netflix = Bulb("netflix",true,R.drawable.netflix)
        val twitch = Bulb("twitch",false,R.drawable.twitch)

        val bulbList: ArrayList<Bulb> = ArrayList()

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
            }else{
                adapter.list[i].isSelected = false
            }
        }
        adapter.notifyDataSetChanged()
    }
}