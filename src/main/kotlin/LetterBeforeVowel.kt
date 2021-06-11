class LetterBeforeVowel : Vowels{
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

    override fun parse(word: String, alphabet: Alphabets): Unit {
        var usedSystematicInference = false;
        println ("User Inputted: ${word.toLowerCase()}");
        val alphabetsHashmap = alphabet.alphabets
        val splitWord = (WordAreaSearch.wordSearch(word))[word.toLowerCase()]
        var splitWordString: String = word.toLowerCase()
        val splitWordSegmentationSet = mutableSetOf<String>()
        val splitWordIndividuallySet = mutableSetOf<String>()
        val vowelReplacementResultSet = mutableSetOf<String>()
        val alphabetReplacementResultSet = mutableSetOf<String>()
        val alphabetReplacementSelector = mutableSetOf<String>()

        // Search for Vowels and Replace

        // 1. Search via Segmentation
        var segmentationSplittingIndex = 0;
        for (segment in splitWord!!) {
            for ((key,value) in this.matchingSounds) {
                for (k in key) {
                    if (segment == k) {
//                        println("This Word Contains ${value}")
                        val newVowel = value.elementAt(0).toString();

                        println("Search via Segmentation Looped")

//                        println("LetterFoundIndex: ${segmentationSplittingIndex}");
//                        println("Letter Replaced @ ${segmentationSplittingIndex}")
                        splitWordSegmentationSet.add((splitWordString.substring(0, segmentationSplittingIndex) + newVowel + splitWordString.substring(segmentationSplittingIndex + 1)))
                    }
                }
            }
            segmentationSplittingIndex+=1;
        }

        // 2. Search via Individual Splitting.
        var individualSplittingIndex = 0;
        for (w in word.toLowerCase()) {
            for ((key,value) in this.matchingSounds) {

//                println("[$key:$value] and w.toString(): ${w.toString()}")


                for (k in key) {
                    if (w.toString() == k) {
//                        println("Letter == K: ${value}")

                        for (vowel in value) {
                            val newVowel = vowel.toString()

//                            println("Search via Individual Splitting")
                            // Supposed to replace the same spot and return save to a variable.
//                        println("LetterFoundIndex: ${individualSplittingIndex}");
                            splitWordString = (splitWordString.substring(0, individualSplittingIndex) + newVowel + splitWordString.substring(individualSplittingIndex + 1))
//                            println("Inserted ${splitWordString}")
                            splitWordIndividuallySet.add(splitWordString)
                        }
                    }
                }
            }

//            println("SplitWordIndividuallySet: ${splitWordIndividuallySet}")

            var individualWordSetCounter = 1;
            for(word in splitWordIndividuallySet) {
                println("${individualWordSetCounter}: ${word}")
                individualWordSetCounter++;
            }


//            println("Letter Replaced @ ${individualSplittingIndex}")
            if (splitWordIndividuallySet.isNotEmpty()) {






                // bอston match with บอสตัน, สนัอบต
                // bะston match with บอสตัน, สนัอบต
                // bัston match with บอสตัน, สนัอบต

                // (บอสตัน, bอston), (สนัอบต, bอston)
                // (บอสตัน, bะston), (สนัอบต, bะston)



                    val setOfClosestWord = mutableSetOf<String>()
                    for (word in splitWordIndividuallySet) {
                        val dictionary: MutableMap<String,MutableList<String>> = mutableMapOf(word to TEST_FILE.thaiWords_TEST)
//                        println(dictionary)
                        for (wordInDict in dictionary[word]!!) {
                            var letterMatchedCounter = 0;
                            wordInDict.forEachIndexed { index, letter ->
                                if (word[index] == letter) {
//                                    println("Letter that were matched: ${letter}")
                                    setOfClosestWord.add(wordInDict)
                                    letterMatchedCounter +=1
                                }
                            }
//                            println("Letter Matched: ${letterMatchedCounter}")
                        }
                    }

                println("Machine Thinks This Word is Closes: '${setOfClosestWord}' 96% similarity (TYPE 'c' TO USE IT)")
                println("Please Select The Closest Sounding Word: (Empty to Skip)")
                var userRequestNumber = readLine()

                if (userRequestNumber.toString() == 'c'.toString()) {
                    usedSystematicInference = true;
                    if (setOfClosestWord.isNotEmpty()) {
                        splitWordSegmentationSet.clear()
                        splitWordIndividuallySet.clear()
                        splitWordIndividuallySet.add(setOfClosestWord.elementAt(0))
                    }
                    break
                } else if (userRequestNumber!!.isNotEmpty() && (individualSplittingIndex+1 < word.toLowerCase().length)) {
                    userRequestNumber = splitWordIndividuallySet.elementAt(userRequestNumber.toInt() - 1);
                    splitWordString = userRequestNumber;
                    splitWordIndividuallySet.clear()
                }


            }
            else if ((individualSplittingIndex+1 == word.toLowerCase().length)) {
//                println("Last Letter Reached")
                splitWordIndividuallySet.add(splitWordString)
//                println("SplitWordIndividuallySet: $splitWordIndividuallySet")
            }


            individualSplittingIndex+=1;
        }

        // Results of Vowel Replacement
        for (word in splitWordSegmentationSet) {
            vowelReplacementResultSet.add(word)
        }
        for (word in splitWordIndividuallySet) {
            vowelReplacementResultSet.add(word)
        }
//        println("VowelReplacementResultSet: ${vowelReplacementResultSet}")

//         Search for Alphabet and Replace
        var parsedWordInserted = false;


        for (result in vowelReplacementResultSet) {
            var parsedWord: String = result.toLowerCase();
            // For each letter inside the result.toLowerCase()
            result.toLowerCase().forEachIndexed { alphabetReplacementIndex, letter ->
                for ((sounds,native_alphas) in alphabetsHashmap) {
                    for (sound in sounds) {
                        if (letter.toString() == sound) {
                            parsedWordInserted = true;
                            for (native_alpha in native_alphas) {
                                parsedWord = (parsedWord.substring(0, alphabetReplacementIndex) + native_alpha + parsedWord.substring(alphabetReplacementIndex + 1))
//                                println("ParsedWord: $parsedWord")
                                alphabetReplacementResultSet.add(parsedWord)
                                alphabetReplacementSelector.add(parsedWord)
                            }
                        } else {
                            parsedWordInserted = false
                        }

                        if (parsedWordInserted) {
                            var resultcounter = 1;
                            println("Generated ${alphabetReplacementResultSet.size} Results in null seconds")
                            for (result in alphabetReplacementResultSet) {
                                println("${resultcounter}: ${result}")
                                resultcounter += 1;
                            }
                            println("Machine Thinks This Word is Closes: 'null' (PRESS ENTER TO USE IT)")
                            println("Please Select The Closest Sounding Word: (Empty to Skip)")
                            val userRequestNumber = readLine()
                            if (userRequestNumber!!.isNotEmpty()) {
                                parsedWord = alphabetReplacementResultSet.elementAt(userRequestNumber!!.toInt()-1)
                            }

                            if (alphabetReplacementIndex == result.toLowerCase().lastIndex) {
                                println("Your Word Is: ${parsedWord}")
                            }

                            alphabetReplacementResultSet.clear()
                        }

                    }
                }
            }
        }


        if (usedSystematicInference) {
            println("Your Word Is: ${vowelReplacementResultSet.elementAt(0)}")
        }

//        var resultcounter = 1;
//        println("Generated ${alphabetReplacementResultSet.size} Results in 0.0000000001123 seconds")
//        for (result in alphabetReplacementResultSet) {
//            println("${resultcounter}: ${result}")
//            resultcounter += 1;
//        }


    }


//    VowelReplacementResultSet: [bอston, MISSING: bอstอn, MISSING: bอstะn, MISSING: bอstัn     , bะston, CORRECT: bัston, bัstอn, bัstะn, bัstัn]



//    1: บะsะtอn
//    2: บะซะtอn
//    3: บะศะtอn
//    4: บะษะtอn
//    5: บะสะtอn
//    Please Select
//    6: บะสะฏอn
//    7: บะสะฐอn
//    8: บะสะฑอn
//    9: บะสะฒอn
//    10: บะสะถอn
//    11: บะสะทอn
//    12: บะสะธอn
//    Please Select
//    13: บะสะธอณ
//    14: บะสะธอน

}