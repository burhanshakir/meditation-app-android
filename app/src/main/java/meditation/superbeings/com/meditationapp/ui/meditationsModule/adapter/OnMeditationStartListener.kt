package meditation.superbeings.com.meditationapp.ui.meditationsModule.adapter

import meditation.superbeings.com.meditationapp.data.Meditation

interface OnMeditationStartListener
{
    fun meditationStartClicked(meditation : Meditation)
}