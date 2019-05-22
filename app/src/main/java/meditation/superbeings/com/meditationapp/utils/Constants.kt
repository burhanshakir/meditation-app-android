package meditation.superbeings.com.meditationapp.utils

import android.view.View

object Constants
{
    const val basicChakra = "Basic Chakra"
    const val advChakra = "Advanced Chakra"
    const val sourceCode = "Source Code"
    const val gspace = "G Space"

    fun getImageFromString(itemView : View, name : String, packageName : String) : Int
    {
        val image : Int = itemView.resources.getIdentifier(name,"drawable",packageName)

        return image
    }
}