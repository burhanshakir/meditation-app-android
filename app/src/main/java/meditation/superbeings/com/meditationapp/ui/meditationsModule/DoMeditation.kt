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
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

class DoMeditation : AppCompatActivity()
{
    lateinit var meditation : Meditation
    var totalMeditationTime : Int = 0
    lateinit var currentDate : Date
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
        storeLatestMeditationData()
    }

    private fun storeLatestMeditationData()
    {
        val sharedPreference =  getSharedPreferences(Constants.latestMeditationPrefs,Context.MODE_PRIVATE)
        val editor = sharedPreference.edit()

        editor.putString(Constants.latestMeditationName, meditation.title)
        editor.putString(Constants.latestMeditationDescription, meditation.description)


        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss", Locale.ENGLISH)
        val currentDateString = sdf.format(Date())
        currentDate = sdf.parse(currentDateString)

        val lastMeditationDateString = sharedPreference.getString(Constants.lastMeditationDate, null)
        var meditationStreak = sharedPreference.getInt(Constants.meditationStreak,0)
        var totalMeditationDone = sharedPreference.getInt(Constants.totalMeditationDone,0)
        totalMeditationTime = sharedPreference.getInt(Constants.totalMeditationTime,0)

        if (lastMeditationDateString != null)
        {
            val lastMeditationDate = sdf.parse(lastMeditationDateString)
            val diff = TimeUnit.DAYS.convert(currentDate.time - lastMeditationDate.time, TimeUnit.MILLISECONDS)

            // If dates are consecutive, increase the counter else set the counter to 1
            meditationStreak = if (diff == 1L) {
                meditationStreak + 1
            } else {
                1
            }

        }
        else
        {
            meditationStreak = 1
        }

        editor.putString(Constants.lastMeditationDate, sdf.format(currentDate))
        editor.putInt(Constants.meditationStreak, meditationStreak)
        editor.putInt(Constants.totalMeditationDone, totalMeditationDone+1)

        editor.apply()
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
            storeMeditationTime()
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

    private fun storeMeditationTime()
    {
        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss", Locale.ENGLISH)

        val timeforFinishString = sdf.format(Date())
        val timeforFinish = sdf.parse(timeforFinishString)

        val activityTimeRun = TimeUnit.SECONDS.convert(timeforFinish.time - currentDate.time , TimeUnit.MILLISECONDS)
        totalMeditationTime = (totalMeditationTime + activityTimeRun).toInt()

        val sharedPreference =  getSharedPreferences(Constants.latestMeditationPrefs,Context.MODE_PRIVATE)
        val editor = sharedPreference.edit()

        val totalMeditationDone = sharedPreference.getInt(Constants.totalMeditationDone, 0)
        val avgMedTime = totalMeditationTime/totalMeditationDone

        editor.putInt(Constants.totalMeditationTime, totalMeditationTime)
        editor.putInt(Constants.avgMeditationTime, avgMedTime)

        editor.apply()
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
