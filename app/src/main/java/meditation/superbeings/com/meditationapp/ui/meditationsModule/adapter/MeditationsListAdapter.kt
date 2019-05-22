package meditation.superbeings.com.meditationapp.ui.meditationsModule.adapter

import meditation.superbeings.com.meditationapp.utils.Constants
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
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
            itemView.tvTitle.text = meditation.title
            Picasso.get()
                .load(Constants.getImageFromString(itemView, meditation.imageName, itemView.context.packageName))
                .into(itemView.ivMeditation)

        }
    }

}