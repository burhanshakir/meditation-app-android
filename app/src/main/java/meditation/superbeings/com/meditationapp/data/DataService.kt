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
        Meditation(title= "8th Chakra", imageName= "eight_chakra"),
        Meditation(title= "Sacrum", imageName= "sacrum"),
        Meditation(title= "9th Chakra", imageName= "ninth_chakra"),
        Meditation(title= "Base", imageName= "base"),
        Meditation(title= "10th Chakra", imageName= "tenth_chakra"))


    private val advChakraCuningSubMeditations = listOf(
    Meditation(title= "Cuning Device", imageName= "empty mind"),
    Meditation(title= "Throat Third Eye", imageName= "throat - third eye"),
    Meditation(title= "Heart Crown", imageName= "heart-crown"),
    Meditation(title= "Solarplex 8th", imageName= "solar plex - 8th"),
    Meditation(title= "Sacrum 9th", imageName= "sacrum - 9th"),
    Meditation(title= "Base 10th", imageName= "base-10th")
    )

    // Souce Code data

    private val sourceCodeSubMeditations = listOf(
    Meditation(title= "Creating", imageName="1-creation"),
    Meditation(title= "Astral", imageName="2-astral"),
    Meditation(title= "Forward Thinking", imageName="3-forwardthinking"),
    Meditation(title= "Relationships", imageName="4-relationships"),
    Meditation(title= "Throat", imageName="5-throat"),
    Meditation(title= "Envy", imageName="6-envy"),
    Meditation(title= "Inner Strength", imageName="7-innerstrength"),
    Meditation(title= "Weight", imageName="8-weight"),
    Meditation(title= "Sacral", imageName="9-sacral"),
    Meditation(title= "Sexuality", imageName="10-sexuality"),
    Meditation(title= "Third Eye", imageName="11-thirdeye"),
    Meditation(title= "Solar Plex", imageName="12-solarplex"),
    Meditation(title= "Vision", imageName="13-vision"),
    Meditation(title= "What If", imageName="14-whatif"),
    Meditation(title= "Release", imageName="15-release"),
    Meditation(title= "Pain", imageName="16-pain"),
    Meditation(title= "Manifest", imageName="17-manifest"),
    Meditation(title= "Anger", imageName="18-anger"),
    Meditation(title= "Skin", imageName="19=kin"),
    Meditation(title= "Love", imageName="20-love"),
    Meditation(title= "Language", imageName="21-language"),
    Meditation(title= "Joy", imageName="22-joy"),
    Meditation(title= "Heart", imageName="23-heart"),
    Meditation(title= "Psychedelic", imageName="24-psychedelic"),
    Meditation(title="Physical", imageName="25-physical"),
    Meditation(title="Guilt", imageName="26-guilt"),
    Meditation(title="Energy", imageName="27-energy"),
    Meditation(title="Definitive Thinking", imageName="28-definitivethinking"),
    Meditation(title="Crown", imageName="29-crown"),
    Meditation(title="Clarity", imageName="30-clarity"),
    Meditation(title="Centering", imageName="31-centeredness"),
    Meditation(title="Circulation", imageName="32-circulation"),
    Meditation(title="Base", imageName="33-base")
    )

    // GSpace Image
    private val gSpaceSubMeditations = listOf(
    Meditation(title= "Gspace", imageName= "gspace")
    )

    private val meditations = listOf(
        Meditation(title = Constants.basicChakra,imageName= "basic_chakra.png",subMeditations= basicChakraCuningSubMeditations, description= "Experience stereoscopic view along with music"),

        Meditation(title= Constants.advChakra, imageName= "adv-chakra.png",subMeditations= advChakraCuningSubMeditations, description= "Experience the Stereoscopic View with Music"),

        Meditation(title= Constants.sourceCode, imageName= "source-code.png",subMeditations= sourceCodeSubMeditations, description= "Advanced Inner Work Using Targeted Symbols"),

        Meditation(title= Constants.gspace, imageName= "g-space.png",subMeditations= gSpaceSubMeditations, description= "Come Together with Others to Powerful Effect")
    )

    private val instructions = listOf(
        MeditationInstruction(name= "Chakra Cuning",description = "Learn more about the proper way to use this powerful meditation system.", instruction= "The first thing to note is that the Chakra Cuning symbols should be used with your eyes viewing the symbols stereoscopically.  Turning your phone to landscape mode will offer the best experience.\n\nWhat is stereoscopic view? It's where you defocus until you see three of the symbols side-by-side, but now they've gone 3D.\n\nIf you have trouble doing this, practice by holding your finger up about ten inches in front of your face, between your eyes and the image, focus on your finger and you'll see beyond your finger that it's gone stereoscopic. Then just lower your finger.\n\nOver time, moving into stereoscopic view will become effortless.\n\nUse the first symbol to empty the mind and get clear. The rest of the symbols are symbols for each designated Chakra.\n\nThere are ten chakras in the basic exercise, which includes three outside the confines of the 3D physical self. The advanced system brings together the symbols in pairs.\n\nThis meditation cunes the chakras, which opens, tunes, energizes and balances each one in turn.\n\nUse the basic Chakra symbol meditation at least five or six times before moving on to the advanced set.  For more information on the Advanced Chakra Cuning, please go here.\n\nThis meditation can be done every day and is an excellent way to start or end the day or at any time you need to clear and calm the mind.\n\n\n\n"),

        MeditationInstruction(name= "Source Code", description= "Learn more about how to use these individual symbols for targeted inner work.", instruction= "To use the Source Code symbols in meditation, start by clearing your mind with the Quiet Mind tool.  You can also use the Chakra Cuning (first) symbol or even both, if you prefer.\n\nWhen ready, scan through the 33 thumbnails and locate the one symbol that stands out more than any other. If you know of an area where you know you need to work, go ahead and select the symbol to address it.  Whichever one you choose, click on it, which will take you to the full-sized version.\n\nEach symbol has a watery effect you can play with, interact with, to deepen the contact between your waking conscious mind, you, your personality, and the deeper, higher, superbeing.\n\nYou have nothing to do but to BE with the symbol.  Be open and receptive, with a clear and empty mind.  Play with the watery symbol as though daydreaming and be open to any information that might come through specifically for you.\n\nTry not to overdo it. This exercise can be very powerful. Work with it for a few minutes, and then stop, once again using your intuition for this length of time.\n\nFor your next session, revisit the same symbol and use your intuition to see whether or not you're finished with it for the time being. If so, move on to a different symbol using the procedure above.\n\n\n\n"),

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

            Meditation(title = "Centeredness", imageName = "31-centeredness"),
            Meditation(title = "Solarplex", imageName = "12-solaplex"),
            Meditation(title = "Forward Thinking", imageName = "3-forwardthinking")
        )
    }




}