package meditation.superbeings.com.meditationapp.ui.instructionModule.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.meditation_instruction_item.view.*
import meditation.superbeings.com.meditationapp.R
import meditation.superbeings.com.meditationapp.data.MeditationInstruction

class InstructionListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>()
{
    private var instructions = listOf<MeditationInstruction>()
    private lateinit var listener : OnInstructionClickListener

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): RecyclerView.ViewHolder
    {
        return MeditationInstructionListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.meditation_instruction_item, parent, false))
    }

    override fun getItemCount(): Int
    {
        return instructions.size
    }

    override fun onBindViewHolder(viewholder: RecyclerView.ViewHolder, position: Int)
    {
        val instructionHolder = viewholder as MeditationInstructionListViewHolder
        instructionHolder.bindView(instructions[position], listener)
    }

    fun setInstructions(instructions:List<MeditationInstruction>, listener: OnInstructionClickListener)
    {
        this.instructions = instructions
        this.listener = listener
        notifyDataSetChanged()
    }

    class MeditationInstructionListViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
    {
        fun bindView(instruction : MeditationInstruction, listener: OnInstructionClickListener)
        {
            itemView.tvMedName.text = instruction.name
            itemView.tvMeditationDescription.text = instruction.description

            itemView.bViewInstruction.setOnClickListener(View.OnClickListener {
                listener.onInstructionClicked(meditation = instruction)
            })

        }
    }

}