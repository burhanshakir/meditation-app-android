package meditation.superbeings.com.meditationapp.ui.instructionModule


import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import meditation.superbeings.com.meditationapp.R
import meditation.superbeings.com.meditationapp.data.MeditationInstruction

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class MeditationInstructionFragment : Fragment() {

    lateinit var meditation: MeditationInstruction
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_meditation_instruction, container, false)

        meditation = arguments?.getSerializable("meditation") as MeditationInstruction

        val tvMeditationName : TextView = view.findViewById(R.id.tvMeditationName)
        val tvInstruction: TextView = view.findViewById(R.id.tvInstruction)

        tvInstruction.movementMethod = ScrollingMovementMethod()

        tvMeditationName.text = meditation.name
        tvInstruction.text = meditation.instruction


        return view
    }

    companion object
    {
        fun newInstance(): MeditationInstructionFragment = MeditationInstructionFragment()
    }


}
