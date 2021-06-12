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
            // 1. Search via Segmentation
            // 2. Search via Individual Splitting
        // Search for Alphabet and Replace



    }
}