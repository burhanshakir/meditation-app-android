package meditation.superbeings.com.meditationapp.ui.MeditationsModule


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import meditation.superbeings.com.meditationapp.R
import meditation.superbeings.com.meditationapp.data.DataService
import meditation.superbeings.com.meditationapp.ui.MeditationsModule.adapter.MeditationsListAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class MeditationsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        val v : View = inflater.inflate(R.layout.fragment_meditations, container, false)
        val recyclerview : RecyclerView = v.findViewById(R.id.rvMeditation)

        val service = DataService

        recyclerview.layoutManager = GridLayoutManager(context,2)


        val adapter = MeditationsListAdapter()
        recyclerview.adapter = adapter
        adapter.setMeditations(service.getMeditations())

        return v
    }

    companion object
    {
        fun newInstance(): MeditationsFragment = MeditationsFragment()
    }


}
