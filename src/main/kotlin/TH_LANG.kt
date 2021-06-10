public class TH_LANG {
    val alphabet: MutableMap<MutableList<String>, MutableList<String>> = mutableMapOf<MutableList<String>, MutableList<String>>();

    init {
        alphabet[mutableListOf("g")] = mutableListOf("ก");
        alphabet[mutableListOf("k","c")] = mutableListOf("ข","ฃ","ค","ฅ","ฆ");
        alphabet[mutableListOf("ng")] = mutableListOf("ง");
        alphabet[mutableListOf("j")] = mutableListOf("จ");
        alphabet[mutableListOf("ch")] = mutableListOf("ฉ","ช","ฌ");
        alphabet[mutableListOf("s")] = mutableListOf("ซ","ศ","ษ","ส");
        alphabet[mutableListOf("y")] = mutableListOf("ญ","ย");
        alphabet[mutableListOf("d")] = mutableListOf("ฎ","ด","ต");
        alphabet[mutableListOf("t")] = mutableListOf("ฏ","ฐ","ฑ","ฒ","ถ","ท","ธ","ต");
        alphabet[mutableListOf("n")] = mutableListOf("ณ","น");
        alphabet[mutableListOf("b")] = mutableListOf("บ");
        alphabet[mutableListOf("p")] = mutableListOf("ป","ผ","พ","ภ");
        alphabet[mutableListOf("f")] = mutableListOf("ฝ","ฟ");
        alphabet[mutableListOf("m")] = mutableListOf("ม");
        alphabet[mutableListOf("r")] = mutableListOf("ร");
        alphabet[mutableListOf("l")] = mutableListOf("ล","ฬ");
        alphabet[mutableListOf("w")] = mutableListOf("ว");
        alphabet[mutableListOf("h")] = mutableListOf("ห","ฮ");
        alphabet[mutableListOf("o")] = mutableListOf("อ");
    }
}