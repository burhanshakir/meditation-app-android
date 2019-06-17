package meditation.superbeings.com.meditationapp.ui.meditationsModule


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import meditation.superbeings.com.meditationapp.utils.Constants


import meditation.superbeings.com.meditationapp.R
import meditation.superbeings.com.meditationapp.data.DataService
import meditation.superbeings.com.meditationapp.data.Meditation
import meditation.superbeings.com.meditationapp.ui.meditationsModule.adapter.MeditationsListAdapter
import meditation.superbeings.com.meditationapp.ui.meditationsModule.adapter.OnMeditationStartListener

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class MeditationsFragment : Fragment(), OnMeditationStartListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        val v : View = inflater.inflate(R.layout.fragment_meditations, container, false)
        val recyclerview : RecyclerView = v.findViewById(R.id.rvMeditation)

        val service = DataService

        recyclerview.layoutManager = GridLayoutManager(context,2) as RecyclerView.LayoutManager?


        val adapter = MeditationsListAdapter()
        recyclerview.adapter = adapter
        adapter.setMeditations(service.getMeditations(), this)

        return v
    }

    companion object
    {
        fun newInstance(): MeditationsFragment = MeditationsFragment()
    }

    override fun meditationStartClicked(meditation: Meditation)
    {
        if(meditation.title == Constants.sourceCode)
        {
            val subMeditationsFragment = SubMeditationsFragment.newInstance()
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.container, subMeditationsFragment)
            transaction?.addToBackStack(null)
            transaction?.commit()
        }
        else if(meditation.title == Constants.advChakra || meditation.title == Constants.basicChakra)
        {
            val intent:Intent = Intent(activity!!.applicationContext, DoMeditation::class.java)
            intent.putExtra("meditation", meditation)
            startActivity(intent)
        }
    }


}
