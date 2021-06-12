class LetterBeforeVowel: Vowels {
    override var matchingSounds: MutableMap<MutableList<String>, MutableList<String>> = mutableMapOf<MutableList<String>, MutableList<String>>();

    init {
        matchingSounds[mutableListOf("a", "aa")] = mutableListOf("า");
        matchingSounds[mutableListOf("ee")] = mutableListOf("ี");
        matchingSounds[mutableListOf("ue")] = mutableListOf("ื");
        matchingSounds[mutableListOf("oo", "u")] = mutableListOf("ู");
        matchingSounds[mutableListOf("or", "aw", "o")] = mutableListOf("อ");
        matchingSounds[mutableListOf("ua", "ue")] = mutableListOf("ัว");
        matchingSounds[mutableListOf("a", "ah","u","o")] = mutableListOf("ะ","ั");
        matchingSounds[mutableListOf("e","i","ie")] = mutableListOf("ิ");
        matchingSounds[mutableListOf("u")] = mutableListOf("ุ");
        matchingSounds[mutableListOf("ua","ew")] = mutableListOf("ัวะ")
        matchingSounds[mutableListOf("um","om")] = mutableListOf("ำ")
    }

    override fun parse(word: String, alphabet: Alphabets) {
        // Search for Vowels and Replace
        // Method 1. Search via Segmentation
        // a.
        // b.
        // c.
        // Method 2. Search via Individual Splitting
        // a.
        // b.
        // c.
        // Method 3. Search Using IndexOf
        // a. If the word contains the 'a' and 'aa' then replace that index with the corresponding vowel.


        // Search for Alphabet and Replace
    }


    fun matchDetails(inputString: String, whatToFind: String, startIndex: Int = 0): String {
        println("whatToFind: ${whatToFind}, startIndex: ${startIndex}")
        val matchIndex = inputString.indexOf(whatToFind, startIndex)
        return "Searching for '$whatToFind' in '$inputString' starting at position $startIndex: " + if (matchIndex >= 0) "Found at $matchIndex" else "Not found"
    }

}