interface Vowels {
    var matchingSounds: MutableMap<MutableList<String>, MutableList<String>>
    fun parse(word: String, alphabet: Alphabets, dictionary: Set<String>): Unit
}