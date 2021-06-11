fun main(args: Array<String>) {
//    var keyFound = false;
//    var vowelsResult: MutableSet<String> = mutableSetOf();
//    var alphabetResult: MutableSet<String> = mutableSetOf();


    // https://www.activethai.com/study-thai/reading-and-writing/learning-the-thai-vowels/practice-the-thai-vowel-names/
    // https://www.activethai.com/study-thai/reading-and-writing/learning-the-thai-vowels/

    print("Enter a word: ")
    val userInputWord = readLine();
    // For each letter in string.
    // Check if the letter is in alphabet and vowels then print the corresponding letter.
//    println("The user entered (ENGLISH): $userInputWord")


    val userInputParser = LetterBeforeVowel().parse(userInputWord!!.toLowerCase(), Alphabets(TH_LANG().alphabet));






    // Only works for า, et al.
//    val resultMap = mutableMapOf<Int, String>();
//    var resultCounter = 1;
//    for (alpha in alphabetResult) {
//        for(vowel in vowelsResult) {
//            resultMap[resultCounter] = "$alpha$vowel"
//            resultCounter += 1;
//        }
//    }
//    for((key,value) in resultMap) {
//        println("$key: ${value}")
//    }







}