package meditation.superbeings.com.meditationapp.ui.instructionModule


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import meditation.superbeings.com.meditationapp.R
import meditation.superbeings.com.meditationapp.data.DataService
import meditation.superbeings.com.meditationapp.ui.instructionModule.adapter.InstructionListAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class InstructionFragment : Fragment()
{

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        val v : View = inflater.inflate(R.layout.fragment_instruction, container, false)
        val recyclerView : RecyclerView = v.findViewById(R.id.rvInstructions)

        val service = DataService

        val instructions = service.getMeditationInstructions()

        recyclerView.layoutManager = LinearLayoutManager(context)

        val adapter = InstructionListAdapter()
        recyclerView.adapter = adapter
        adapter.setInstructions(instructions)




        return v
    }

    companion object
    {
        fun newInstance(): InstructionFragment = InstructionFragment()
    }


}
