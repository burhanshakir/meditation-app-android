package meditation.superbeings.com.meditationapp.utils

import android.graphics.drawable.Drawable
import android.view.View

object Constants
{
    const val basicChakra = "Basic Chakra"
    const val advChakra = "Advanced Chakra"
    const val sourceCode = "Source Code"
    const val gspace = "G Space"

    const val chakraCuningSettings = "Chakra Cuning"
    const val gSpaceSettings = "G Space"
    const val sourceCodeSettings = "Source Code"

    const val prefsInit = "isPrefInitialized"
    const val prefsMusic = "isMusicEabled"
    const val prefsTimer = "timer"
    const val prefsReminder = "isReminderEnabled"
    const val prefsReminderTime = "reminderTime"
    const val prefsReminderFrequency = "reminderFrequency"
    const val prefsIsLandscapeLocked = "isLadscapeLocked"

    const val latestMeditationPrefs = "Latest Meditation Prefs"
    const val latestMeditationName = "Latest Meditation Name"
    const val latestMeditationDescription = "Latest Meditation Description"


    fun getImageFromString(itemView : View, name : String, packageName : String) : Int
    {
        val image : Int = itemView.resources.getIdentifier(name,"drawable",packageName)

        return image
    }
}