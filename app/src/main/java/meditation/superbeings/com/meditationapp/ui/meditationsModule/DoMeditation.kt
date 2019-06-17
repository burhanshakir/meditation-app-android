package meditation.superbeings.com.meditationapp.ui.meditationsModule

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import meditation.superbeings.com.meditationapp.R
import meditation.superbeings.com.meditationapp.data.Meditation

class DoMeditation : AppCompatActivity()
{
    lateinit var meditation : Meditation
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_do_meditation)

        meditation = getIntent().getSerializableExtra("meditation") as Meditation
    }
}
