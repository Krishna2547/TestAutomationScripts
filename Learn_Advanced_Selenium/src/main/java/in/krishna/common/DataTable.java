/**
 * 
 */
package in.krishna.common;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.testng.annotations.Parameters;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import bsh.This;

/**
 * @author Krishna
 *
 */
public class DataTable {
	

public HashMap<String, String> Data(String path){
		
		HashMap<String, String> data=new HashMap<String, String>();
		
	try {
		
		Scanner in =new Scanner(new File(path));
	String line;
	while(in.hasNextLine())
	{
		line=in.nextLine();
		String[] keyvalue=line.split("=");
		keyvalue[1]=keyvalue[1].trim();
		data.put(keyvalue[0], keyvalue[1]);	
	}
	
in.close();	

		}catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		return data;
	}
	
	/*
	public void xmlreader() {
		
		try {
		    File fXmlFile = new File("./src/main/resources/EnviromentVariabels.xml");
		    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		    Document doc = dBuilder.parse(fXmlFile);
		    doc.getDocumentElement().normalize();

		    System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		    NodeList nList = doc.getElementsByTagName("site");
		    System.out.println("----------------------------");

		    for (int temp = 0; temp < nList.getLength(); temp++) {
		        Node nNode = nList.item(temp);
		        System.out.println("\nCurrent Element :" + nNode.getNodeName());
		        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		            Element eElement = (Element) nNode;
		            System.out.println("Staff id : "
		                               + eElement.getAttribute("id"));
		            System.out.println("First Name : "
		                               + eElement.getElementsByTagName("firstname")
		                                 .item(0).getTextContent());
		            System.out.println("Last Name : "
		                               + eElement.getElementsByTagName("lastname")
		                                 .item(0).getTextContent());
		            System.out.println("Nick Name : "
		                               + eElement.getElementsByTagName("nickname")
		                                 .item(0).getTextContent());
		            System.out.println("Salary : "
		                               + eElement.getElementsByTagName("salary")
		                                 .item(0).getTextContent());
		        }
		    }
		    } catch (Exception e) {
		    e.printStackTrace();
		    }
	}
	*/
	
	
}
