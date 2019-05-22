package meditation.superbeings.com.meditationapp.ui.homeModule.adapter

import meditation.superbeings.com.meditationapp.utils.Constants
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.home_meditation_item.view.*
import meditation.superbeings.com.meditationapp.R
import meditation.superbeings.com.meditationapp.data.Meditation

class HomeMeditationAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> ()
{
    private var meditations = listOf<Meditation>()

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): RecyclerView.ViewHolder
    {
        return HomeMeditationVH(LayoutInflater.from(parent.context).inflate(R.layout.home_meditation_item, parent, false))
    }

    override fun getItemCount(): Int
    {
        return meditations.size
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, p1: Int)
    {
        val meditationHolder = viewHolder as HomeMeditationVH
        meditationHolder.bindView(meditation = meditations[p1])
    }

    fun setMeditations(meditations : List<Meditation>)
    {
        this.meditations = meditations
        notifyDataSetChanged()
    }



    class HomeMeditationVH(itemView : View) : RecyclerView.ViewHolder(itemView)
    {
        fun bindView(meditation : Meditation)
        {
            itemView.tvName.text = meditation.title
            Picasso.get()
                .load(Constants.getImageFromString(itemView,meditation.imageName,itemView.context.packageName))
                .into(itemView.ivMeditation)
        }
    }


}