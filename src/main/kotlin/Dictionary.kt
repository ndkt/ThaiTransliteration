import java.io.File

class Dictionary {
    companion object {
        private val dictionaryString: String = File("dictionary.txt").readText()
        public val parsedDictionary: Set<String> = dictionaryString
            .substring(1,dictionaryString.length-1)
            .strip()
            .split(",")
            .toSet()
    }

    public fun readDictionary(): Set<String> {
        val myXMLParser = XMLParser();
        myXMLParser.parseXML()
        val parsedDictionaryXML: Set<String> = myXMLParser.dictionaryString.split(",").toSet();
        return parsedDictionaryXML
    }
}