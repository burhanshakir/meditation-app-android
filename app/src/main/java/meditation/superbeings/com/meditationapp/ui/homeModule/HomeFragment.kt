package meditation.superbeings.com.meditationapp.ui.homeModule


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import meditation.superbeings.com.meditationapp.R
import meditation.superbeings.com.meditationapp.data.DataService
import meditation.superbeings.com.meditationapp.ui.homeModule.adapter.HomeMeditationAdapter
import meditation.superbeings.com.meditationapp.utils.Constants

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
        // Get Latest Meditation Data

        val sharedPreference =  activity!!.getSharedPreferences(Constants.latestMeditationPrefs, Context.MODE_PRIVATE)
        val meditationName = sharedPreference.getString(Constants.latestMeditationName, Constants.advChakra)
        val meditationDesc = sharedPreference.getString(Constants.latestMeditationDescription, Constants.advChakraDesc)
        val medStreak = sharedPreference.getInt(Constants.meditationStreak,0)
        val avgTime = sharedPreference.getInt(Constants.avgMeditationTime, 0)

        val tvLatestMeditationName : TextView = v.findViewById(R.id.tvLatestMeditationName)
        val tvLatestMeditationDescription : TextView = v.findViewById(R.id.tvLatestMeditationDescription)
        val tvMeditationStreak : TextView = v.findViewById(R.id.tvMeditationStreak)
        val tvAvgTime : TextView = v.findViewById(R.id.tvAvgMeditationTime)


        tvLatestMeditationName.text = meditationName
        tvLatestMeditationDescription.text = meditationDesc
        tvMeditationStreak.text = medStreak.toString()
        tvAvgTime.text = avgMedTimeToString(avgTime)

        val recyclerview : RecyclerView = v.findViewById(R.id.rvHomeMeditations)
        val service = DataService

        recyclerview.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

        val adapter = HomeMeditationAdapter()
        recyclerview.adapter = adapter
        adapter.setMeditations(service.getLatestMeditaion())


    }

    private fun avgMedTimeToString(time : Int) : String
    {
        val min = (time % 3600) / 60
        val sec = time % 60

        val timeString = String.format("%02d:%02d", min,sec) + " mins"

        return timeString

    }

    companion object
    {
        fun newInstance(): HomeFragment = HomeFragment()
    }


}
