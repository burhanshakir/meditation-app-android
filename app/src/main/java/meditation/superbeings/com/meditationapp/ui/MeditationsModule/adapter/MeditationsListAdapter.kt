package meditation.superbeings.com.meditationapp.ui.MeditationsModule.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.meditation_item.view.*
import meditation.superbeings.com.meditationapp.R
import meditation.superbeings.com.meditationapp.data.Meditation

class MeditationsListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>()
{

    private var meditations = listOf<Meditation>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
    {

        return MeditationListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.meditation_item, parent, false))
    }

    override fun getItemCount(): Int
    {

        return meditations.size
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int)
    {

        val meditationHolder = viewHolder as MeditationListViewHolder
        meditationHolder.bindView(meditation = meditations[position])
    }

    fun setMeditations(meditations : List<Meditation>)
    {
        this.meditations = meditations
        notifyDataSetChanged()
    }



    class MeditationListViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
    {
        fun bindView(meditation : Meditation)
        {
            itemView.tvMeditationName.text = meditation.title
        }
    }

}