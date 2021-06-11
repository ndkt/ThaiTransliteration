import org.w3c.dom.Element
import org.w3c.dom.Node
import java.io.File
import java.lang.Exception
import javax.xml.parsers.DocumentBuilderFactory

class XMLParser {
    var dictionaryString = ""
        private set

    fun parseXML() {
        try {
            val inputFile = File("yaitron.xml")
            val dictionaryFactory = DocumentBuilderFactory.newInstance()
            val builder = dictionaryFactory.newDocumentBuilder()
            val dictionary = builder.parse(inputFile)
            dictionary.documentElement.normalize()
            //            System.out.println("Root element :" + dictionary.getDocumentElement().getNodeName());
            val nList = dictionary.getElementsByTagName("entry")
            //            System.out.println("----------------------------");
            for (temp in 0 until nList.length) {
                val nNode = nList.item(temp)
                //                System.out.println("\nCurrent Element : " + nNode.getNodeName());
                if (nNode.nodeType == Node.ELEMENT_NODE) {
                    val eElement = nNode as Element
                    val language = eElement.getAttribute("lang").strip().strip()
                    if (language == "tha") {
//                        System.out.println("LANG : " + eElement.getAttribute("lang"));
//                        System.out.println("Word : " + eElement.getElementsByTagName("headword").item(0).getTextContent());
                        dictionaryString += eElement.getElementsByTagName("headword").item(0).textContent + ", "
                        dictionaryString = dictionaryString
                        if (eElement.getElementsByTagName("synonym").item(0) != null) {
//                            System.out.println("Synonym : " + eElement.getElementsByTagName("synonym").item(0).getTextContent());
                            dictionaryString += eElement.getElementsByTagName("synonym").item(0).textContent + ", "
                            dictionaryString = dictionaryString
                        }
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}