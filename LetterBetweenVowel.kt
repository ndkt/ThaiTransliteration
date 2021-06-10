class LetterBetweenVowel : Vowels{
    override var matchingSounds: MutableMap<MutableList<String>, MutableList<String>> = mutableMapOf<MutableList<String>, MutableList<String>>();

    init {
        matchingSounds[mutableListOf("er","e")] = mutableListOf("เ-อ")
        matchingSounds[mutableListOf("ia")] = mutableListOf("เ-ีย")
        matchingSounds[mutableListOf("uua","ua")] = mutableListOf("เ-ือ")
        matchingSounds[mutableListOf("a","eh")] = mutableListOf("เ-ะ")
        matchingSounds[mutableListOf("a")] = mutableListOf("แ-ะ")
        matchingSounds[mutableListOf("o","oh")] = mutableListOf("โ-ะ")
        matchingSounds[mutableListOf("aw","o")] = mutableListOf("เ-าะ")
        matchingSounds[mutableListOf("e","uh")] = mutableListOf("เ-อะ")
        matchingSounds[mutableListOf("ia","ea")] = mutableListOf("เ-ียะ")
        matchingSounds[mutableListOf("ua","a")] = mutableListOf("เ-ือะ")
        matchingSounds[mutableListOf("ao","aw")] = mutableListOf("เ-า")
    }
    
    override fun parse(word: String, alphabet: Alphabets): Unit {
        TODO("Not yet implemented")
    }
}