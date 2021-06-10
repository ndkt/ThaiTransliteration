class WordAreaSearch {
    companion object {
        public fun wordSearch(word: String): MutableMap<String,MutableList<String>> {
            val wordHashMap: MutableMap<String,MutableList<String>> = mutableMapOf<String,MutableList<String>>()
            var k = 0;
            var letterThisRound: MutableList<String> = mutableListOf();
            var stopLoop = false;
            for(i in 1..word.length) {
                for (n in 1..i) {
//                    print("${i}:")
                    if (i==1) {
                        // Base Case
//                        print("${word.elementAt(0)} [${i-1}]\n")
                        letterThisRound.add(word.elementAt(0).toString());
                        wordHashMap["${word}"] = mutableListOf("${word.elementAt(0)}")
                        k = i+1;
                    } else {
                        // All Other Cases
//                        print("${word.elementAt(k-1)} [${k-1}]\n")
                        letterThisRound.add(word.elementAt(k-1).toString());
                        k ++;
                    }
                    if(k-1 == word.length) {
                        // Stop Inner Loop
                        stopLoop = true;
                        break
                    }

                }
                if (i!=1){
                    wordHashMap["${word}"]!!.add("${letterThisRound.joinToString("")}");
                }
//                println("NUMBER CHANGED, LETTERS THIS ROUND: $letterThisRound")
                letterThisRound.clear();


                if(stopLoop) {
                    // Stop Outer Loop
                    break
                }
            }
            return wordHashMap;
        }
    }
}