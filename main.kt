fun main(args: Array<String>) {
    var keyFound = false;
    var vowelsResult: MutableSet<String> = mutableSetOf();
    var alphabetResult: MutableSet<String> = mutableSetOf();

    print("Enter a word: ")
    val userInputWord = readLine();
   

    val userInputParser = LetterBeforeVowel().parse(userInputWord!!.toLowerCase(), Alphabets(TH_LANG().alphabet));

}
