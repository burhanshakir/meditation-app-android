package meditation.superbeings.com.meditationapp.ui.settingsModule


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

import meditation.superbeings.com.meditationapp.R
import meditation.superbeings.com.meditationapp.utils.Constants
import kotlin.concurrent.timer

/**
 * A simple [Fragment] subclass.
 *
 */
class SettingsFragment : Fragment() {

    lateinit var llChakraCuning : LinearLayout
    lateinit var llSourceCode : LinearLayout
    lateinit var llGSpace : LinearLayout
    lateinit var selectedMeditation : String
    private lateinit var selectedMeditationLayout : LinearLayout
    lateinit var tvTimer : TextView
    lateinit var sMusic : Switch
    lateinit var sReminder : Switch
    lateinit var sLandscape : Switch

    var timerValue : Int = 0
    var isMusicEnabled : Boolean = false
    var isLandscapeEnabled : Boolean = true
    var isReminderEnabled : Boolean = false

    private val RESULT_CODE = 3

    companion object
    {
        fun newInstance(): SettingsFragment = SettingsFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        val v : View = inflater.inflate(R.layout.fragment_settings, container, false)

        setUpViews(v)

        return v
    }

    private fun setUpViews(v : View)
    {
        llChakraCuning = v.findViewById(R.id.llChakraCuning)
        llSourceCode = v.findViewById(R.id.llSourceCode)
        llGSpace = v.findViewById(R.id.llGSpace)
        tvTimer = v.findViewById(R.id.tvTimer)
        sMusic = v.findViewById(R.id.switchMusic)
        sReminder = v.findViewById(R.id.switchReminder)
        sLandscape = v.findViewById(R.id.switchLandscape)
        val bEnter : Button = v.findViewById(R.id.bEnter)

        // Default selections
        selectedMeditation = Constants.chakraCuningSettings
        selectedMeditationLayout = llChakraCuning


        // Onclick events
        llChakraCuning.setOnClickListener(View.OnClickListener { selectedMeditationChanged(Constants.chakraCuningSettings, llChakraCuning) })
        llGSpace.setOnClickListener(View.OnClickListener { selectedMeditationChanged(Constants.gSpaceSettings, llGSpace) })
        llSourceCode.setOnClickListener(View.OnClickListener { selectedMeditationChanged(Constants.sourceCodeSettings, llSourceCode) })
        bEnter.setOnClickListener(View.OnClickListener { settingsSaved(selectedMeditation) })

        tvTimer.setOnClickListener(View.OnClickListener {

            val intent = Intent(activity!!.applicationContext, SetTimerActivity::class.java)
            startActivityForResult(intent, RESULT_CODE)

        })

        loadSettings(selectedMeditation)
    }

    private fun selectedMeditationChanged(setting : String, view : LinearLayout)
    {
        Log.d("Settings changed", setting)

        view.setBackgroundColor(ContextCompat.getColor(view.context, R.color.light_blue))

        // Changing previous layout color
        selectedMeditationLayout.setBackgroundColor(ContextCompat.getColor(selectedMeditationLayout.context,android.R.color.black))

        selectedMeditation = setting
        selectedMeditationLayout = view

        loadSettings(selectedMeditation)

    }

    private fun loadSettings(settings : String)
    {
        val sharedPreference =  activity!!.getSharedPreferences(settings, Context.MODE_PRIVATE)

        if(sharedPreference != null && sharedPreference.contains(Constants.prefsInit))
        {
            timerValue = sharedPreference.getInt(Constants.prefsTimer,0)

            isMusicEnabled = sharedPreference.getBoolean(Constants.prefsMusic, false)
            isLandscapeEnabled = sharedPreference.getBoolean(Constants.prefsIsLandscapeLocked, true)
            isReminderEnabled = sharedPreference.getBoolean(Constants.prefsReminder,false)

            sMusic.isChecked = isMusicEnabled
            sReminder.isChecked = isReminderEnabled
            sLandscape.isChecked = isLandscapeEnabled

            // TODO : change format of timer value text and then set to textview
            //tvTimer.setText(timerValue)


        }
        // Load Default Settings
        else
        {
            sMusic.isChecked = false
            sReminder.isChecked = false
            sLandscape.isChecked = true
        }

    }

    private fun settingsSaved(selectedMeditation : String)
    {
        val sharedPreference =  activity!!.getSharedPreferences(selectedMeditation,Context.MODE_PRIVATE)
        val editor = sharedPreference.edit()

        editor.putBoolean(Constants.prefsInit, true)
        editor.putBoolean(Constants.prefsReminder, sReminder.isEnabled)
        editor.putBoolean(Constants.prefsIsLandscapeLocked, sLandscape.isEnabled)
        editor.putBoolean(Constants.prefsMusic, sMusic.isEnabled)
        editor.putInt(Constants.prefsTimer, timerValue)

        editor.apply()

        Toast.makeText(activity!!.baseContext, "Settings saved!", Toast.LENGTH_SHORT).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, data)


        if (resultCode == Activity.RESULT_OK)
        {
            Log.i("onActivityResult", "Received")
            timerValue = data!!.getIntExtra("result", 0)

            val hours = data.getIntExtra("hours", 0)
            val mins = data.getIntExtra("mins", 0)

            tvTimer.setText(hours.toString() + "H:" + mins.toString() + "M:00S" )

        }

    }
}
