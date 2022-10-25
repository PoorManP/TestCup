package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CreateXml {
    public static void createXml() {
        try {
            // 1.创建DocumentBuilderFactory对象
            DocumentBuilderFactory factory = DocumentBuilderFactory
                    .newInstance();
            // 2.创建DocumentBuilder对象
            DocumentBuilder builder = factory.newDocumentBuilder();
            // 3.创建Document对象
            Document document = builder.newDocument();
            // 4.设置不显示“standalone="no"”
            document.setXmlStandalone(true);

            // 5.创建根元素bookstore
            Element students = document.createElement("students");

            HashMap<String, String> map1 = new HashMap<>();
            map1.put("id", "20100101");
            map1.put("java", "96");
            map1.put("uml", "90");
            map1.put("oracle", "88");
            map1.put("name", "王宏");
            HashMap<String, String> map2 = new HashMap<>();
            map2.put("id", "20100102");
            map2.put("java", "76");
            map2.put("uml", "70");
            map2.put("oracle", "56");
            map2.put("name", "李娜");
            HashMap<String, String> map3 = new HashMap<>();
            map3.put("id", "20100103");
            map3.put("java", "70");
            map3.put("uml", "80");
            map3.put("oracle", "77");
            map3.put("name", "孙武");

            ArrayList<Map<String,String>> val = new ArrayList<>();
            val.add(map1);
            val.add(map2);
            val.add(map3);
            // 6.循环向bookstore根节点中添加子节点book
            for (int i = 0; i < 3; i++) {
                Element element = createElement(document,val.get(i));

                students.appendChild(element);
            }



            document.appendChild(students);
            // 10.将bookstore节点（已包含book）添加到dom树中


            // 11.创建TransformerFactory对象
            TransformerFactory tff = TransformerFactory.newInstance();
            // 12.创建 Transformer对象
            Transformer tf = tff.newTransformer();
            // 13.输出内容是否使用换行
            tf.setOutputProperty(OutputKeys.INDENT, "yes");

            // 14.创建xml文件并写入内容
            tf.transform(new DOMSource(document), new StreamResult(new File(
                    "students.xml")));
            System.out.println("生成students.xml成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("生成book1.xml失败");
        }
    }

    public static Element  createElement(Document document,Map<String,String> map) throws ParserConfigurationException {

        Element student = document.createElement("student");
            student.setAttribute("id",map.get("id"));
            // 7.向book根节点中添加子节点name
            Element name = document.createElement("name");
            name.setTextContent(map.get("name"));
            Element java = document.createElement("java");
            java.setTextContent(map.get("java"));
            Element oracle = document.createElement("oracle");
            oracle.setTextContent(map.get("oracle"));

            Element uml = document.createElement("uml");
            uml.setTextContent(map.get("uml"));
            // 向book根节点中添加子节点author
            // 向book根节点中添加子节点author
            // 9.将book节点添加到bookstore根节点中
            student.appendChild(name);
            student.appendChild(uml);
            student.appendChild(oracle);
            student.appendChild(java);



            return student;

    }
    public static void main(String[] args) {
        createXml();
    }
}
