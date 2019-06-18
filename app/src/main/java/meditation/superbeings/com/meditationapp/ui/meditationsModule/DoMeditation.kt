package meditation.superbeings.com.meditationapp.ui.meditationsModule

import android.annotation.SuppressLint
import android.content.Context
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_do_meditation.*
import meditation.superbeings.com.meditationapp.utils.Constants
import meditation.superbeings.com.meditationapp.R
import meditation.superbeings.com.meditationapp.data.Meditation
import java.util.*

class DoMeditation : AppCompatActivity()
{
    lateinit var meditation : Meditation
    private var selectedMeditationIndex : Int = 0
    private var mediaPlayer : MediaPlayer? = null

    // Default settings
    private var timerValue = 60 * 1000
    private var isLandscapeLock = true
    private var isMusicEnabled = false
    private var isReminderEnabled = false
    private var isMute = false
    private var isButtonsHidden = true


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_do_meditation)

        meditation = getIntent().getSerializableExtra("meditation") as Meditation
        selectedMeditationIndex = meditation.selectedMeditationIndex
        setUpViews()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setUpViews()
    {
        // Getting shared preferences

        val settings = when {
            meditation.title.contains("Chakra") -> Constants.chakraCuningSettings
            meditation.title.contains("Source") -> Constants.sourceCodeSettings
            else -> Constants.gSpaceSettings
        }


        val sharedPreference = getSharedPreferences(settings, Context.MODE_PRIVATE)

        if(sharedPreference != null && sharedPreference.contains(Constants.prefsInit))
        {
            timerValue = sharedPreference.getInt(Constants.prefsTimer,60) * 1000

            isMusicEnabled = sharedPreference.getBoolean(Constants.prefsMusic, false)
            isLandscapeLock = sharedPreference.getBoolean(Constants.prefsIsLandscapeLocked, true)
            isReminderEnabled = sharedPreference.getBoolean(Constants.prefsReminder,false)

        }

        if(isMusicEnabled)
        {
            mediaPlayer = MediaPlayer.create(this, R.raw.spaceambientmix)
            mediaPlayer?.setOnPreparedListener(MediaPlayer.OnPreparedListener {
                mediaPlayer?.start()
            })
        }
        else
        {
            isMute = true
            ivSound.setBackgroundResource(R.drawable.unmute)
        }

        val bNext = findViewById<Button>(R.id.bNext)
        val bHome = findViewById<Button>(R.id.bHome)

        val ivMeditation = findViewById<ImageView>(R.id.ivMedImg)

        val subMeditation = meditation.subMeditations

        // Change image based on timer

        val timer = Timer()
        val monitor = object : TimerTask() {
            override fun run()
            {
                selectedMeditationIndex++

                changeImage(subMeditation,ivMeditation)
            }
        }

        timer.schedule(monitor, timerValue.toLong(), timerValue.toLong())

        // Loading first image
        Picasso.get()
            .load(Constants.getImageFromString(ivMeditation, subMeditation.get(selectedMeditationIndex).imageName, ivMeditation.context.packageName))
            .into(ivMeditation)


        // Onclick events
        bNext.setOnClickListener(View.OnClickListener {
            selectedMeditationIndex++

            changeImage(subMeditation,ivMeditation)
        })

        bHome.setOnClickListener(View.OnClickListener {

            mediaPlayer?.stop()
            finish()
        })

        ivSound.setOnClickListener(View.OnClickListener {
            if(isMute)
            {
                ivSound.setBackgroundResource(R.drawable.mute)
                mediaPlayer?.start()
            }

            else
            {
                ivSound.setBackgroundResource(R.drawable.unmute)
                mediaPlayer?.pause()
            }

            isMute = !isMute
        })

        ivMeditation.setOnClickListener(View.OnClickListener{
            if(isButtonsHidden)
            {
                bNext.visibility = View.VISIBLE
                bHome.visibility = View.VISIBLE
                ivSound.visibility = View.VISIBLE


            }
            else {
                bNext.visibility = View.INVISIBLE
                bHome.visibility = View.INVISIBLE
                ivSound.visibility = View.INVISIBLE
            }

            isButtonsHidden = !isButtonsHidden
        })


    }

    private fun changeImage(subMeditation : List<Meditation>, ivMeditation : ImageView)
    {
        if(selectedMeditationIndex < subMeditation.size)
        {
            Handler(Looper.getMainLooper()).post {

                Picasso.get()
                    .load(Constants.getImageFromString(ivMeditation, subMeditation.get(selectedMeditationIndex).imageName, ivMeditation.context.packageName))
                    .into(ivMeditation)
            }
        }
    }
}
