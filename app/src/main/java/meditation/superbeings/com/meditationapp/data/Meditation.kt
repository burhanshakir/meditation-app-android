package meditation.superbeings.com.meditationapp.data

import java.io.Serializable

data class Meditation(var title : String, var imageName: String, var selectedMeditationIndex: Int = 0,
                             val subMeditations : List<Meditation> = emptyList(), var description : String = "",
                             var instruction : String = "", var instructionDescription : String = "", val thumbnail : String = "" ) : Serializable