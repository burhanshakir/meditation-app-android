package meditation.superbeings.com.meditationapp.data

import meditation.superbeings.com.meditationapp.utils.Constants

// Singleton object
object DataService
{
    private val basicChakraCuningSubMeditations = listOf(
        Meditation(title= "Cuning Device", imageName= "empty_mind"),
        Meditation(title= "Throat", imageName= "throat"),
        Meditation(title= "Third Eye", imageName= "third_eye"),
        Meditation(title= "Heart", imageName= "heart"),
        Meditation(title= "Crown", imageName= "crown"),
        Meditation(title= "Solarplex", imageName= "solarplex"),
        Meditation(title= "8th Chakra", imageName= "eightchakra"),
        Meditation(title= "Sacrum", imageName= "sacrum"),
        Meditation(title= "9th Chakra", imageName= "ninthchakra"),
        Meditation(title= "Base", imageName= "base"),
        Meditation(title= "10th Chakra", imageName= "tenthchakra"))


    private val advChakraCuningSubMeditations = listOf(
    Meditation(title= "Cuning Device", imageName= "empty_mind"),
    Meditation(title= "Throat Third Eye", imageName= "throat_third_eye"),
    Meditation(title= "Heart Crown", imageName= "heart_crown"),
    Meditation(title= "Solarplex 8th", imageName= "solarplex_eighth"),
    Meditation(title= "Sacrum 9th", imageName= "sacrum_ninth"),
    Meditation(title= "Base 10th", imageName= "base_tenth")
    )

    // Souce Code data

    private val sourceCodeSubMeditations = listOf(
    Meditation(title= "Creating", imageName="creation"),
    Meditation(title= "Astral", imageName="astral"),
    Meditation(title= "Forward Thinking", imageName="forwardthinking"),
    Meditation(title= "Relationships", imageName="relationships"),
    Meditation(title= "Throat", imageName="throat"),
    Meditation(title= "Envy", imageName="envy"),
    Meditation(title= "Inner Strength", imageName="innerstrength"),
    Meditation(title= "Weight", imageName="weight"),
    Meditation(title= "Sacral", imageName="sacral"),
    Meditation(title= "Sexuality", imageName="sexuality"),
    Meditation(title= "Third Eye", imageName="thirdeye"),
    Meditation(title= "Solar Plex", imageName="solarplex"),
    Meditation(title= "Vision", imageName="vision"),
    Meditation(title= "What If", imageName="whatif"),
    Meditation(title= "Release", imageName="release"),
    Meditation(title= "Pain", imageName="pain"),
    Meditation(title= "Manifest", imageName="manifest"),
    Meditation(title= "Anger", imageName="anger"),
    Meditation(title= "Skin", imageName="skin"),
    Meditation(title= "Love", imageName="love"),
    Meditation(title= "Language", imageName="language"),
    Meditation(title= "Joy", imageName="joy"),
    Meditation(title= "Heart", imageName="heart"),
    Meditation(title= "Psychedelic", imageName="psychedelic"),
    Meditation(title="Physical", imageName="physical"),
    Meditation(title="Guilt", imageName="guilt"),
    Meditation(title="Energy", imageName="energy"),
    Meditation(title="Definitive Thinking", imageName="definitivethinking"),
    Meditation(title="Crown", imageName="crown"),
    Meditation(title="Clarity", imageName="clarity"),
    Meditation(title="Centering", imageName="centeredness"),
    Meditation(title="Circulation", imageName="circulation"),
    Meditation(title="Base", imageName="base")
    )

    // GSpace Image
    private val gSpaceSubMeditations = listOf(
    Meditation(title= "Gspace", imageName= "gspace")
    )

    private val meditations = listOf(
        Meditation(title = Constants.basicChakra,imageName= "basic_chakra",subMeditations= basicChakraCuningSubMeditations, description= "Experience stereoscopic view along with music"),

        Meditation(title= Constants.advChakra, imageName= "adv_chakra",subMeditations= advChakraCuningSubMeditations, description= "Experience the Stereoscopic View with Music"),

        Meditation(title= Constants.sourceCode, imageName= "source_code",subMeditations= sourceCodeSubMeditations, description= "Advanced Inner Work Using Targeted Symbols"),

        Meditation(title= Constants.gspace, imageName= "g_space",subMeditations= gSpaceSubMeditations, description= "Come Together with Others to Powerful Effect")
    )

    private val instructions = listOf(
        MeditationInstruction(name= "Chakra Cuning",description = "Learn more about the proper way to use this powerful meditation system.", instruction= "The first thing to note is that the Chakra Cuning symbols should be used with your eyes viewing the symbols stereoscopically.  Turning your phone to landscape mode will offer the best experience.\n\nWhat is stereoscopic view? It's where you defocus until you see three of the symbols side-by-side, but now they've gone 3D.\n\nIf you have trouble doing this, practice by holding your finger up about ten inches in front of your face, between your eyes and the image, focus on your finger and you'll see beyond your finger that it's gone stereoscopic. Then just lower your finger.\n\nOver time, moving into stereoscopic view will become effortless.\n\nUse the first symbol to empty the mind and get clear. The rest of the symbols are symbols for each designated Chakra.\n\nThere are ten chakras in the basic exercise, which includes three outside the confines of the 3D physical self. The advanced system brings together the symbols in pairs.\n\nThis meditation cunes the chakras, which opens, tunes, energizes and balances each one in turn.\n\nUse the basic Chakra symbol meditation at least five or six times before moving on to the advanced set.  For more information on the Advanced Chakra Cuning, please go here.\n\nThis meditation can be done every day and is an excellent way to start or end the day or at any time you need to clear and calm the mind.\n\n\n\n"),

        MeditationInstruction(name= "Source Code", description= "Learn more about how to use these individual symbols for targeted inner work.", instruction= "To use the Source Code symbols in meditation, start by clearing your mind with the Quiet Mind tool.  You can also use the Chakra Cuning (first) symbol or even both, if you prefer.\n\nWhen ready, scan through the 33 thumbnails and locate the one symbol that stands out more than any other. If you know of an area where you know you need to work, go ahead and select the symbol to address it.  Whichever one you choose, click on it, which will take you to the full-sized version.\n\nEach symbol has a watery effect you can play with, interact with, to deepen the contact between your waking conscious mind, you, your personality, and the deeper, higher, superbeing.\n\nYou have nothing to do but to BE with the symbol.  Be open and receptive, with a clear and empty_mind.  Play with the watery symbol as though daydreaming and be open to any information that might come through specifically for you.\n\nTry not to overdo it. This exercise can be very powerful. Work with it for a few minutes, and then stop, once again using your intuition for this length of time.\n\nFor your next session, revisit the same symbol and use your intuition to see whether or not you're finished with it for the time being. If so, move on to a different symbol using the procedure above.\n\n\n\n"),

        MeditationInstruction(name= "G Space", description= "Learn more about our group meditation space.", instruction= "G Space stands for Group Space.  While the other meditations are meant for individual practice, this one harnesses the energies of multiple people.  Put another way, it’s a meeting 'place' for group meditations.\n\nIf you have ever gone to a group sitting, you likely already know the power of collective energy.  It can be a very healing, cleansing, and invigorating experience.\n\nThis virtual space is consciously constructed to be free of our personal visualizations, intents or anything else we seek to generate individually. This is about allowing something beyond the scope of our personal conscious level of being to bloom.\n\nYou can invite friends who also have the TSB Meditation app to join you at a specified time.  Come together, get open and empty, and allow the energy to flow.\n\nG Space is inherently about bringing the best out of every sharer. In this way, your own personal group, be it 2 or 200, will be constantly blossoming, like a flower with as many petals as there are sharers, becoming an ever-increasingly potent transmitter of the unity ideal.\n\n\n\n")


    )

    // Get Meditation Data
    fun getMeditations(): List<Meditation>
    {
        return meditations
    }

    fun getMeditationInstructions() : List<MeditationInstruction>
    {
        return instructions
    }

    fun getBasicMeditations() : List<Meditation>
    {
        val basicMeditations = getBasicMeditations()
        basicMeditations.drop(1)

        return basicMeditations
    }

    fun getLatestMeditaion() : List<Meditation>
    {
        return listOf(

            Meditation(title = "Centeredness", imageName = "centeredness"),
            Meditation(title = "Solarplex", imageName = "solarplex"),
            Meditation(title = "Forward Thinking", imageName = "forwardthinking")
        )
    }

    fun getSourceCodeSubMeditations() : List<Meditation>
    {
        return sourceCodeSubMeditations
    }




}