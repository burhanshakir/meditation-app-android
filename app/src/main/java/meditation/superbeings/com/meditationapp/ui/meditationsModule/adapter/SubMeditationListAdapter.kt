package meditation.superbeings.com.meditationapp.ui.meditationsModule.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.meditation_item.view.ivMeditation
import kotlinx.android.synthetic.main.meditation_item.view.tvTitle
import meditation.superbeings.com.meditationapp.R
import meditation.superbeings.com.meditationapp.data.Meditation
import meditation.superbeings.com.meditationapp.utils.Constants

class SubMeditationListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>()
{
    private var meditations = listOf<Meditation>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
    {
        return SubMeditationListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.sub_meditation_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int
    {
        return meditations.size
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int)
    {
        val meditationHolder = viewHolder as SubMeditationListViewHolder
        meditationHolder.bindView(meditation = meditations[position])
    }

    fun setMeditations(meditations : List<Meditation>)
    {
        this.meditations = meditations
        notifyDataSetChanged()
    }

    class SubMeditationListViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
    {
        fun bindView(meditation : Meditation)
        {
            itemView.tvTitle.text = meditation.title
            Picasso.get()
                .load(Constants.getImageFromString(itemView, meditation.imageName, itemView.context.packageName))
                .into(itemView.ivMeditation)

//            itemView.ivMeditation.setImageResource(Constants.getImageFromString(itemView, meditation.imageName, itemView.context.packageName))

        }
    }

}