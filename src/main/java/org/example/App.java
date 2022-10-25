package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        String filePath = "C:\\Users\\Animal\\Desktop\\xstl\\1.xml";
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = dbf.newDocumentBuilder();

            File file = new File(filePath);
            Document parse = documentBuilder.parse(file);

            Element root = parse.getDocumentElement();


            NodeList childNodes = root.getChildNodes();

            for (int i = 0; i < childNodes.getLength(); i++) {
                Node item = childNodes.item(i);

                if(item.getNodeName().equals("student")){
                    NodeList childNodes1 = item.getChildNodes();

                    for (int j = 0; j < childNodes1.getLength(); j++) {
                        System.out.println(childNodes1.item(j).getTextContent());
                    }
                }
            }


        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }
}
