/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Jacco
 */
public class CfgMySql {

    private Document document;
    private String filepath;
    public CfgMySql(String filepath ) throws ParserConfigurationException, SAXException, IOException {
       // String filepath = "C:\\Users\\Jacco.FLIA\\Desktop\\xd\\integrados\\src\\main\\resources\\hibernate.cfg.xml";
       
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = factory.newDocumentBuilder();

        document = docBuilder.parse(filepath);
        document.setXmlVersion("1.0");
    }

    public void modificarXml(String user, String password) {
        Element session;
        session = (Element) document.getElementsByTagName("session-factory").item(0);
        System.out.println(session.getNodeName());
        NodeList list = session.getChildNodes();
        
        Node node = list.item(7);
        
        if ("property".equals(node.getNodeName()) && node.getAttributes().getNamedItem("name").getTextContent().equals("hibernate.connection.username")) {
            node.setTextContent(user);
            System.out.println(node.getTextContent());
        }
       node = list.item(9);

        if ("property".equals(node.getNodeName()) && node.getAttributes().getNamedItem("name").getTextContent().equals("hibernate.connection.password")) {
            node.setTextContent(password);
            System.out.println(node.getTextContent());
        }

    }

    public void generarXml() throws TransformerConfigurationException, TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(this.document);
        String filepath = this.filepath;
        StreamResult result = new StreamResult(new File(filepath));
        transformer.transform(source, result);
    }
}
