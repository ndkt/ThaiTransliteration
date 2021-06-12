fun main(args: Array<String>) {
    /**
     * YAITRON Thai Dictionary XML: Copyright (c) 2003 National Electronics and Computer Technology Center (NECTEC).
     * https://github.com/veer66/Yaitron
     */

    print("Enter a word: ")
    val userInputWord = readLine();
//    val readDict = Dictionary()
    val userInputParser = LetterBeforeVowel().parse(userInputWord!!.toLowerCase(), Alphabets(TH_LANG().alphabet));



}
