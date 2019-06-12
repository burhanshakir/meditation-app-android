package meditation.superbeings.com.meditationapp.ui.meditationsModule


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import meditation.superbeings.com.meditationapp.R
import meditation.superbeings.com.meditationapp.data.DataService
import meditation.superbeings.com.meditationapp.ui.meditationsModule.adapter.MeditationsListAdapter
import meditation.superbeings.com.meditationapp.ui.meditationsModule.adapter.SubMeditationListAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class SubMeditationsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        val v : View = inflater.inflate(R.layout.fragment_sub_meditations, container, false)
        val recyclerview : RecyclerView = v.findViewById(R.id.rvSubMeditations)

        val service = DataService

        recyclerview.layoutManager = GridLayoutManager(context,3) as RecyclerView.LayoutManager?


        val adapter = SubMeditationListAdapter()
        recyclerview.adapter = adapter
        adapter.setMeditations(service.getSourceCodeSubMeditations())

        return v
    }

    companion object
    {
        fun newInstance(): SubMeditationsFragment = SubMeditationsFragment()
    }


}
