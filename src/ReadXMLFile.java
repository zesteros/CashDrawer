
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.FileWriter;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class ReadXMLFile {

    public String[] readFile() {
        String[] para = new String[2];
        try {

            File file = new File("config.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList configParameters = doc.getElementsByTagName("config");

            for (int i = 0; i < configParameters.getLength(); i++) {

                Node node = configParameters.item(i);

                System.out.println("\nCurrent Element :" + node.getNodeName());

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;

                    System.out.println("config id : " + element.getAttribute("id"));
                    System.out.println("port : " + element.getElementsByTagName("port").item(0).getTextContent());
                    para[0] = element.getElementsByTagName("port").item(0).getTextContent();
                    System.out.println("pass : " + element.getElementsByTagName("password").item(0).getTextContent());
                    para[1] = element.getElementsByTagName("password").item(0).getTextContent();

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return para;
    }

    public boolean writeFile(String field, String data) {
        try {

            File file = new File("config.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList configParameters = doc.getElementsByTagName("config");

            for (int i = 0; i < configParameters.getLength(); i++) {

                Node node = configParameters.item(i);

                System.out.println("\nCurrent Element :" + node.getNodeName());

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;

                    System.out.println("config id : " + element.getAttribute("id"));
                    if (field.equals("port")) {
                        element.getElementsByTagName("port").item(0).setTextContent(data);
                    } else if (field.equals("password")) {
                        element.getElementsByTagName("password").item(0).setTextContent(data);
                    }

                }
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("config.xml"));

            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);

            System.out.println("File saved!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
