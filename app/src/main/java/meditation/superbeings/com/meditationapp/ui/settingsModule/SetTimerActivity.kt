package meditation.superbeings.com.meditationapp.ui.settingsModule

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.NumberPicker
import meditation.superbeings.com.meditationapp.R

class SetTimerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_timer)

        val npHours : NumberPicker = findViewById(R.id.npHours)
        val npMins : NumberPicker = findViewById(R.id.npMins)
        val bSave : Button = findViewById(R.id.bSave)

        npHours.minValue = 0
        npHours.maxValue = 23

        npMins.minValue = 1
        npMins.maxValue = 59

        // Save pressed
        bSave.setOnClickListener(View.OnClickListener {

            val hours = npHours.value
            val mins = npMins.value

            val timer = (hours * 60 * 60) + (mins * 60)

            val returnIntent = Intent()
            returnIntent.putExtra("result", timer)
            returnIntent.putExtra("hours", hours)
            returnIntent.putExtra("mins", mins)
            setResult(Activity.RESULT_OK, returnIntent)
            finish()


        })
    }
}
