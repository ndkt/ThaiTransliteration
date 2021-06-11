class LetterAfterVowel : Vowels{
    override var matchingSounds: MutableMap<MutableList<String>, MutableList<String>> = mutableMapOf<MutableList<String>, MutableList<String>>();

    init {
        matchingSounds[mutableListOf("ay", "ae", "a")] = mutableListOf("เ")
        matchingSounds[mutableListOf("ae","air","aa","a")] = mutableListOf("แ")
        matchingSounds[mutableListOf("oe","o","ow")] = mutableListOf("โ")
        matchingSounds[mutableListOf("ai")] = mutableListOf("ใ")
        matchingSounds[mutableListOf("ai")] = mutableListOf("ไ")
    }

    override fun parse(word: String, alphabet: Alphabets): Unit {
        TODO("Not yet implemented")
    }
}