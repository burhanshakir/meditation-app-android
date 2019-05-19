package meditation.superbeings.com.meditationapp.ui.homeModule


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import meditation.superbeings.com.meditationapp.R
import meditation.superbeings.com.meditationapp.data.DataService
import meditation.superbeings.com.meditationapp.ui.homeModule.adapter.HomeMeditationAdapter

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        val v : View = inflater.inflate(R.layout.fragment_home, container, false)

        setUpViews(v)

        return v
    }

    private fun setUpViews(v : View)
    {
        val recyclerview : RecyclerView = v.findViewById(R.id.rvHomeMeditations)
        val service = DataService

        recyclerview.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

        val adapter = HomeMeditationAdapter()
        recyclerview.adapter = adapter
        adapter.setMeditations(service.getLatestMeditaion())


    }

    companion object
    {
        fun newInstance(): HomeFragment = HomeFragment()
    }


}
