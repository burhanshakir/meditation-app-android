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
        Meditation(title= "8th Chakra", imageName= "eighthchakra"),
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
    Meditation(title= "Creating", imageName="creation", thumbnail = "creations_sm"),
    Meditation(title= "Astral", imageName="astral", thumbnail = "astrals_sm"),
    Meditation(title= "Forward Thinking", imageName="forwardthinking", thumbnail = "forwardthinkings_sm"),
    Meditation(title= "Relationships", imageName="relationships", thumbnail = "relationships_sm"),
    Meditation(title= "Throat", imageName="throat", thumbnail = "throats_sm"),
    Meditation(title= "Envy", imageName="envy", thumbnail = "envys_sm"),
    Meditation(title= "Inner Strength", imageName="innerstrength", thumbnail = "strengths_sm"),
    Meditation(title= "Weight", imageName="weight", thumbnail = "weights_sm"),
    Meditation(title= "Sacral", imageName="sacral", thumbnail = "sacrals_sm"),
    Meditation(title= "Sexuality", imageName="sexuality", thumbnail = "sexualitys_sm"),
    Meditation(title= "Third Eye", imageName="third_eye", thumbnail = "thirdeyes_sm"),
    Meditation(title= "Solar Plex", imageName="solarplex", thumbnail = "solarplexs_sm"),
    Meditation(title= "Vision", imageName="vision", thumbnail = "visions_sm"),
    Meditation(title= "What If", imageName="whatif", thumbnail = "whatifs_sm"),
    Meditation(title= "Release", imageName="release", thumbnail = "releases_sm"),
    Meditation(title= "Pain", imageName="pain", thumbnail = "pains_sm"),
    Meditation(title= "Manifest", imageName="manifest", thumbnail = "manifests_sm"),
    Meditation(title= "Anger", imageName="anger", thumbnail = "angers_sm"),
    Meditation(title= "Skin", imageName="skin", thumbnail = "skins_sm"),
    Meditation(title= "Love", imageName="love", thumbnail = "loves_sm"),
    Meditation(title= "Language", imageName="language", thumbnail = "languages_sm"),
    Meditation(title= "Joy", imageName="joy", thumbnail = "joys_sm"),
    Meditation(title= "Heart", imageName="heart", thumbnail = "hearts_sm"),
    Meditation(title= "Psychedelic", imageName="psychedelic", thumbnail = "psychedelics_sm"),
    Meditation(title="Physical", imageName="physical", thumbnail = "physicals_sm"),
    Meditation(title="Guilt", imageName="guilt", thumbnail = "guilts_sm"),
    Meditation(title="Energy", imageName="energy", thumbnail = "energys_sm"),
    Meditation(title="Definitive Thinking", imageName="definitivethinking", thumbnail = "definitivethinkings_sm"),
    Meditation(title="Crown", imageName="crown", thumbnail = "crowns_sm"),
    Meditation(title="Clarity", imageName="clarity", thumbnail = "claritys_sm"),
    Meditation(title="Centering", imageName="centeredness", thumbnail = "centerednesss_sm"),
    Meditation(title="Circulation", imageName="circulation", thumbnail = "circulations_sm"),
    Meditation(title="Base", imageName="base", thumbnail = "bases_sm")
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

            Meditation(title = "Centeredness", imageName = "centerednesss_sm"),
            Meditation(title = "Solarplex", imageName = "solarplexs_sm"),
            Meditation(title = "Forward Thinking", imageName = "forwardthinkings_sm")
        )
    }

    fun getSourceCodeSubMeditations() : List<Meditation>
    {
        return sourceCodeSubMeditations
    }




}